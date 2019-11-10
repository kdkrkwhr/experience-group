package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noticeNo;

	private String subject;
	
	@Column(length = 100000000)
	private String content;

	private String regDate;

	@Column(insertable=false, updatable=false)
	private int fileNo;
}
