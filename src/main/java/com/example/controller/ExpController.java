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
	 * 메인 화면 컨트롤러
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/experience", method = RequestMethod.GET)
	public String main(Model model) {
		log.info("메인 화면");
		return "index";
	}

	/**
	 * 체험단 신청하기 화면 컨트롤러
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/experience/board", method = RequestMethod.GET)
	public String noticeList(Model model) {
		log.info("체험단 신청하기");
		return "exp";
	}
}
