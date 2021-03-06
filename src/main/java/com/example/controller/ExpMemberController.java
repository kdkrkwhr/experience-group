package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import com.example.model.ExpMember;
import com.example.model.Experience;
import com.example.repository.ExpMemberRepository;
import com.example.repository.ExperienceRepository;
import com.example.util.ExcelView;
import com.example.util.MemberExcelView;

@Controller
@RequestMapping("/servlet/member")
public class ExpMemberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExpMemberController.class);

	static final String SUCCESS = "SUCCESS";
	static final String NO_VALUE_ERROR = "NO VALUE";

	@Autowired
	private ExpMemberRepository expMemberRepository;

	@Autowired
	private ExperienceRepository experienceRepository;

	@RequestMapping(value="/applylist/{idx}", method=RequestMethod.GET)
	public String getExpMembers(@PathVariable("idx") int idx, Model model) {
		List<ExpMember> memberList = new ArrayList<ExpMember>();

		try {

			memberList = expMemberRepository.expList(idx);
			model.addAttribute("idx", idx);
			model.addAttribute("memberList", memberList);
		} catch(Exception e) {
			LOGGER.info("EXP_MEM LIST / ERROR {}", e.getMessage());
		}

		return "expMemberList";
	}

	@RequestMapping(value="/api/check/{idx}", method=RequestMethod.GET)
	public ResponseEntity<Boolean> checkCntExpMember(@PathVariable("idx") int idx) {
		Experience exp = experienceRepository.findById(idx).get();
		boolean checkFlag = false;
		int recrutCnt = exp.getRecrutCnt();
		int appliCnt = exp.getAppliCnt();
		int resultCnt = recrutCnt - appliCnt;

		if (resultCnt > 0) {
			// true : 신청 가능
			checkFlag = true;
		} else {
			// false : 신청 불가능
			checkFlag = false;
		}

		return new ResponseEntity<>(checkFlag, HttpStatus.OK);
	}

	@RequestMapping(value="/api/register", method=RequestMethod.POST)
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

	@RequestMapping(value="/api/cntupdate/{idx}", method=RequestMethod.POST)
	public ResponseEntity<String> cntExpMember(@PathVariable("idx") int idx) {

		try {

			expMemberRepository.expCntUp(idx);
		} catch (Exception e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@RequestMapping(value="/api/excel/{idx}", method=RequestMethod.GET)
	public void memberExcel(@PathVariable("idx") int idx, HttpServletResponse res) throws Exception {
		List<ExpMember> memberList = expMemberRepository.expList(idx);
		MemberExcelView.writeNoticeListToFile("Member.xlsx", memberList, res);
	}
}
