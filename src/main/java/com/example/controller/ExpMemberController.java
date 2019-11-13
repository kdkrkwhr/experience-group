package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repository.NoticeRepository;

@Controller
@RequestMapping("/member")
public class ExpMemberController {

	private static final Logger log = LoggerFactory.getLogger(ExpMemberController.class);

	static final String SUCCESS = "SUCCESS";
	static final String NO_VALUE_ERROR = "NO VALUE";

	@Autowired
	private NoticeRepository expMemberRepository;
}
