package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experience {

	// 글번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int experienceNo;

	// 글 제목
	private String subject;
	
	// 유형 (페이스북, 네이버블로그 등등,,)
	private String type;
	
	// 신청인원
	private int appliCnt;
	
	// 모집인원
	private int recrutCnt;
	
	// 등록일
	private String regDate;
	
	// 상품명
	private String prdName;
	
	// 글 내용
	@Column(length = 100000000)
	private String content;

	@Builder
	public Experience(String subject, String type, int appliCnt, int recrutCnt, String regDate, String prdName, String content) {

		this.subject	= subject;
		this.type		= type;
		this.appliCnt	= appliCnt;
		this.recrutCnt	= recrutCnt;
		this.regDate	= regDate;
		this.prdName	= prdName;
		this.content	= content;
	}
}
