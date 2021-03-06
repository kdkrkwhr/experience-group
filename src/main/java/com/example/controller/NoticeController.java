package com.example.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.model.Notice;
import com.example.repository.NoticeRepository;
import com.example.util.ExcelView;

@Controller
@RequestMapping("/servlet/notice")
public class NoticeController {

	private static final Logger log = LoggerFactory.getLogger(NoticeController.class);

	static final String SUCCESS = "SUCCESS";
	static final String NO_VALUE_ERROR = "NO VALUE";

	@Autowired
	private NoticeRepository noticeRepository;

	// 공지사항 리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String noticeList(final Pageable pageable, Model model) {
		log.info("NOTICE LIST PAGE");

		try {

			Page<Notice> noticeList = noticeRepository.findAll(pageable);
			model.addAttribute("totalPage", noticeList.getTotalPages());
			model.addAttribute("nowPageNum", pageable.getPageNumber());
			model.addAttribute("list", noticeList);

		} catch(Exception e) {
			return e.getMessage();
		}

		return "noticeList";
	}

	// 공지사항 상세 조회
	@RequestMapping(value = "/view/{idx}", method = RequestMethod.GET)
	public String noticeView(@PathVariable("idx") int idx, Model model) {
		log.info("NOTICE USER VIEW PAGE");

		try {

			Notice notice = noticeRepository.findById(idx).get();
			model.addAttribute("notice", notice);
			model.addAttribute("cat", "공지사항");

		} catch(Exception e) {
			return e.getMessage();
		}

		return "noticeDetail";
	}

	// 공지사항 상세 조회 (관리자용)
	@RequestMapping(value = "/admin/view/{idx}", method = RequestMethod.GET)
	public String noticeAdminView(@PathVariable("idx") int idx, Model model) {
		log.info("NOTICE ADMIN VIEW PAGE");

		try {

			Notice notice = noticeRepository.findById(idx).get();
			model.addAttribute("notice", notice);
			model.addAttribute("cat", "공지사항 수정");
			model.addAttribute("btnId", "updateBtn");
			model.addAttribute("btnCat", "수정");

		} catch(Exception e) {
			return e.getMessage();
		}

		return "noticeRegister";
	}

	// 공지사항 수정
	@RequestMapping(value = "/api/update/{idx}", method = RequestMethod.PUT)
	public ResponseEntity<String> noticeUpdate(@PathVariable("idx") int idx, @RequestBody Notice reqNotice) {
		log.info("NOTICE UPDATE REST API");

		try {

			Notice notice = noticeRepository.findById(idx).get();
			notice.setSubject(reqNotice.getSubject());
			notice.setContent(reqNotice.getContent());
			notice.setFilePath(reqNotice.getFilePath());

			noticeRepository.save(notice);

		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	// 공지사항 삭제
	@RequestMapping(value = "/api/delete/{idx}", method = RequestMethod.DELETE)
	public ResponseEntity<String> noticceDelete(@PathVariable("idx") int idx) {
		log.info("NOTICE DELETE REST API");

		try {
			noticeRepository.deleteById(idx);
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	// 공지사항 등록 페이지
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String registerPage(Model model) {
		log.info("NOTICE REGISTER PAGE");

		model.addAttribute("cat", "공지사항 등록");
		model.addAttribute("btnId", "registerBtn");
		model.addAttribute("btnCat", "등록");

		return "noticeRegister";
	}

	// 공지사항 엑셀 다운로드
	@RequestMapping(value = "/api/excel", method = RequestMethod.GET)
	public ResponseEntity<String> noticeExcelDownload(final Pageable pageable) throws Exception {
		log.info("NOTICE EXCEL DOWNLOAD");

		try {

			Page<Notice> noticeList = noticeRepository.findAll(pageable);
			ExcelView.writeNoticeListToFile("Notice.xlsx", noticeList);

		} catch(Exception e) {
			log.error("ER / {}", e.getMessage());
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}
	
	// 공지사항 등록
	@Value("${file.upload-dir}")
	String uploadPath;
	@RequestMapping(value = "/api/register", method = RequestMethod.POST)
	public String noticeAdd(@RequestParam("input_file") MultipartFile file, MultipartHttpServletRequest request, Model model) {
		log.info("NOTICE REGISTER REST API");
		try {
			String uploadPath = request.getSession().getServletContext().getRealPath(File.separator + "uploads");
			String fileFullPath = uploadPath + File.separator + file.getOriginalFilename();
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");

			SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd / HH:mm:ss");
			Date dateTime = new Date();
			String date = format.format(dateTime);

			File folder = new File(uploadPath);
			if (!folder.exists()) {
				folder.mkdir();
			}
			
			if (!file.getOriginalFilename().isEmpty()) {
				file.transferTo(new File(fileFullPath));
			}

			//db
			noticeRepository.save(
					Notice.builder()
					.subject(subject)
					.content(content)
					.regDate(date)
					.filePath(fileFullPath)
					.build());

			model.addAttribute("msg", SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "redirect:/servlet/notice/list?sort=noticeNo,desc&size=5";
		}
		return "redirect:/servlet/notice/list?sort=noticeNo,desc&size=5";
	}
	
	@RequestMapping(value = "/fileDownload", method = RequestMethod.GET)
	public String fileDownload(HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String filePath = (String)request.getParameter("filePath");
		model.addAttribute("filePath", filePath);
		filePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/";
		return "fileDownload";
	}

}