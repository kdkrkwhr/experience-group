package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExpController {

	private static final Logger log = LoggerFactory.getLogger(ExpController.class);

	/**
	 * 메인 화면
	 * 최신 순으로 정렬하여 보여준다.
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/experience", method = RequestMethod.GET)
	public String main(Model model) {
		log.info("메인 화면");
		return "index";
	}

	/**
	 * 체험단 신청하기 게시글 목록 화면
	 * 최신 순으로 정렬하여 보여준다.
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/experience/board", method = RequestMethod.GET)
	public String noticeList(Model model) {
		log.info("체험단 신청하기 게시글 목록");
		return "exp";
	}
	
	/**
	 * 체험단 신청 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/experience/board/applyExp", method = RequestMethod.GET)
	public String applyExp(Model model) {
		log.info("체험단 신청하기 상세페이지");
		model.addAttribute("cat", "체험단 신청하기");
		return "applyExp";
	}
}
