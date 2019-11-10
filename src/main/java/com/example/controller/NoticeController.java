package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.repository.NoticeRepository;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	static final String SUCCESS = "SUCCESS";
	static final String NO_VALUE_ERROR = "NO VALUE";

	@Autowired
	private NoticeRepository noticeRepository;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void noticeList() {
		
	}
}
