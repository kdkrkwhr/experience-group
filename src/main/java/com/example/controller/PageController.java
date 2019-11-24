package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repository.ExperienceRepository;

@Controller
public class PageController {

	@Autowired
	ExperienceRepository er;

	@RequestMapping(value = "/")
	public String main(Model model) {
		
		model.addAttribute("expList", er.ExperienceBoardSelect());
		return "index";
	}
}
