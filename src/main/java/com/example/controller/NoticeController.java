package com.example.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.model.Notice;
import com.example.repository.NoticeRepository;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	private static final Logger log = LoggerFactory.getLogger(NoticeController.class);

	static final String SUCCESS = "SUCCESS";
	static final String NO_VALUE_ERROR = "NO VALUE";

	@Autowired
	private NoticeRepository noticeRepository;

	// 공지사항 리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String noticeList(final Pageable pageable, Model model) {
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
		try {
			Notice notice = noticeRepository.findById(idx).get();
			model.addAttribute("notice", notice);
			model.addAttribute("cat", "공지사항");
			model.addAttribute("btnCat", "");
		} catch(Exception e) {
			return e.getMessage();
		}
		return "noticeDetail";
	}

	// 공지사항 상세 조회 (관리자용)
	@RequestMapping(value = "/admin/view/{idx}", method = RequestMethod.GET)
	public String noticeAdminView(@PathVariable("idx") int idx, Model model) {
		try {
			Notice notice = noticeRepository.findById(idx).get();
			model.addAttribute("notice", notice);
			model.addAttribute("cat", "공지사항");
			model.addAttribute("btnCat", "");
		} catch(Exception e) {
			return e.getMessage();
		}
		return "noticeRegister";
	}

	// 공지사항 등록
	@RequestMapping(value="/api/register", method=RequestMethod.POST)
	public ResponseEntity<String> noticeAdd(@RequestBody Notice reqNotice) {
		try {
			LocalDateTime date = LocalDateTime.now();
			noticeRepository.save(
					Notice.builder()
					.subject(reqNotice.getSubject())
					.content(reqNotice.getContent())
					.regDate(date.toString())
					.filePath(reqNotice.getFilePath())
					.build());
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	// 공지사항 수정
	@RequestMapping(value="/api/update/{idx}", method = RequestMethod.PUT)
	public ResponseEntity<String> noticeUpdate(@PathVariable("idx") int idx) {
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	// 공지사항 삭제
	@RequestMapping(value="/api/delete/{idx}", method=RequestMethod.DELETE)
	public ResponseEntity<String> noticceDelete(@PathVariable("idx") int idx) {
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
		model.addAttribute("btnCat", "등록");
		return "noticeRegister";
	}
}