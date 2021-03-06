package com.example.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

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

import com.example.model.Experience;
import com.example.repository.ExperienceRepository;

@Controller
@RequestMapping(value = "/servlet/experience")
public class ExperienceController {

	private static final Logger log = LoggerFactory.getLogger(ExperienceController.class);

	@Autowired
	ExperienceRepository er;

	/**
	 * 체험단 신청하기 게시글 등록 화면
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String registerPage(Model model) {
		log.info("체험단 신청하기 게시글 목록");

		model.addAttribute("cat", "등록");
		model.addAttribute("btnId", "btnRegister");
		model.addAttribute("btnCat", "등록");
		return "expRegister";
	}
	
	/**
	 * 체험단 신청하기 게시글 목록 화면
	 * 최신 순으로 정렬하여 보여준다.
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String noticeList(Model model) {
		log.info("체험단 신청하기 게시글 목록");
		model.addAttribute("expList", er.ExperienceBoardSelect());
		return "index";
	}
	
	/**
	 * 체험단 신청 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/board/{idx}", method = RequestMethod.GET)
	public String applyExp(@PathVariable("idx") int idx, Model model) {
		log.info("체험단 신청하기 상세페이지");
		try {
			model.addAttribute("exp", er.selectOne(idx));
		} catch (Exception e) {
			log.error("글 정보 조회 실패");
		}
		model.addAttribute("cat", "체험단 신청하기");
		return "applyExp";
	}

	/**
	 * 체험단 신청글 등록 API
	 * 
	 * @param model, @RequestBody Experience req
	 * @return
	 */
	@RequestMapping(value="/api/register", method=RequestMethod.POST)
	public ResponseEntity<String> insertExp(@RequestBody Experience req) {
		String msg = "";

		try {

			SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd / HH:mm");
			Date dateTime = new Date();
			String date = format.format(dateTime);

			er.save(Experience.builder()
					.subject(req.getSubject())
					.type(req.getType())
					.appliCnt(req.getAppliCnt())
					.recrutCnt(req.getRecrutCnt())
					.regDate(date)
					.prdName(req.getPrdName())
					.content(req.getContent())
					.build());

			msg = "SUCCESS";

		} catch(Exception e) {
			msg = e.getMessage();
		}

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	/**
	 * 체험단 신청글 수정 API
	 * 
	 * @param model, @RequestBody Experience req
	 * @return
	 */
	@RequestMapping(value="/api/update/{idx}", method=RequestMethod.PUT)
	public ResponseEntity<String> updateExp(@PathVariable("idx") int idx, @RequestBody Experience req) {
		String msg = "";
		
		try {
			Experience experience = er.findById(idx).get();
			experience.setSubject(req.getSubject());
			experience.setType(req.getType());
			experience.setRecrutCnt(req.getRecrutCnt());
			er.save(experience);
			msg = "SUCCESS";

		} catch(Exception e) {
			msg = e.getMessage();
		}

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	/**
	 * 체험단 신청글 삭제 API
	 * 
	 * @PathVariable int idx
	 * @return
	 */
	@RequestMapping(value="/api/delete/{idx}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delExp(@PathVariable("idx") int idx) {
		String msg = "";
		try {
			er.deleteById(idx);
			
			msg = "SUCCESS";
		} catch(Exception e) {
			msg = e.getMessage();
		}

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
