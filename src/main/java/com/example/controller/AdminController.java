package com.example.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Admin;
import com.example.repository.AdminRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminRepository adminRepository;

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<Boolean> adminLogin(HttpSession session, @RequestBody Admin reqAdmin) {
		Boolean adminLoginFlag = false;

		try {
			Admin admin = adminRepository.adminLogin(reqAdmin.getAdminEmail(), reqAdmin.getAdminPassword());

			if (admin != null) {
				adminLoginFlag = true;
				session.setAttribute("sessionAdmin", admin);
				log.info("LOGIN SUCCESS");

			} else {
				adminLoginFlag = false;
				log.info("LOGIN FAIL");

			}

		} catch(Exception e) {
			log.info("ADMIN / LOGIN : {}", e.getMessage());			
		}

		return new ResponseEntity<>(adminLoginFlag, HttpStatus.OK);
	}

	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public ResponseEntity<String> adminLogout(HttpSession session) {

		try {
			session.removeAttribute("sessionAdmin");
		} catch(Exception e) {
			log.info("ADMIN / LOGOUT : {}", e.getMessage());
		}

		return new ResponseEntity<>("LOGOUT_SUCCESS", HttpStatus.OK);
	}
}
