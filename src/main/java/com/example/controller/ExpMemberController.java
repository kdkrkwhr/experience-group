package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.ExpMember;
import com.example.repository.ExpMemberRepository;

@Controller
@RequestMapping("/member")
public class ExpMemberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExpMemberController.class);

	static final String SUCCESS = "SUCCESS";
	static final String NO_VALUE_ERROR = "NO VALUE";

	@Autowired
	private ExpMemberRepository expMemberRepository;

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<String> postExpMember(@RequestBody ExpMember reqMember) {

		LOGGER.info("EXP_MEM_ADD");

		try {

			expMemberRepository.save(
					ExpMember.builder()
					.experienceNo(reqMember.getExperienceNo())
					.blogAddress(reqMember.getBlogAddress())
					.email(reqMember.getEmail())
					.name(reqMember.getName())
					.phone(reqMember.getPhone())
					.address(reqMember.getAddress())
					.prdName(reqMember.getPrdName())
					.memo(reqMember.getMemo())
					.build());

		} catch(Exception e) {
			LOGGER.info("EXP_MEM ADD / ERROR {}", e.getMessage());
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}
}
