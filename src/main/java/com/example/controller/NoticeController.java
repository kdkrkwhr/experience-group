package com.example.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	public String main(Model model) {
		try {
			List<Notice> noticeList = noticeRepository.noticeAllList();
			model.addAttribute("list", noticeList);
		} catch(Exception e) {
			return e.getMessage();
		}
		return "noticeList";
	}

	// 공지사항 상세 조회
	@RequestMapping(value = "/view/{idx}", method = RequestMethod.GET)
	public String noticeList(@PathVariable("idx") int idx, Model model) {
		try {
			Notice notice = noticeRepository.findById(idx).get();
			model.addAttribute("notice", notice);
			model.addAttribute("cat", "공지사항 수정");
			model.addAttribute("btnCat", "수정");
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
					.fileNo(reqNotice.getFileNo())
					.build());
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	// 공지사항 수정
	@RequestMapping(value="/update/{idx}", method = RequestMethod.PUT)
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