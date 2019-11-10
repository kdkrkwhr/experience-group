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
	private int board_no;

	// 글 제목
	private String subject;
	
	// 유형 (페이스북, 네이버블로그 등등,,)
	private String type;
	
	// 신청인원
	private int appli_cnt;
	
	// 모집인원
	private int recrut_cnt;
	
	// 등록일
	private String reg_date;
	
	// 상품명
	private String prd_name;
	
	// 글 내용
	@Column(length = 100000000)
	private String content;

	@Builder
	public Experience(String subject, String type, int appli_cnt, int recrut_cnt, String reg_date, String prd_name, String content) {

		this.subject	= subject;
		this.type		= type;
		this.appli_cnt	= appli_cnt;
		this.recrut_cnt	= recrut_cnt;
		this.reg_date	= reg_date;
		this.prd_name	= prd_name;
		this.content	= content;
	}
}
