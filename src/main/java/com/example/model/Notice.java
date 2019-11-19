package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Builder;
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

	private String filePath;

	@Builder
	public Notice(String subject, String content, String regDate, String filePath) {

		this.subject = subject;
		this.content = content;
		this.regDate = regDate;
		this.filePath = filePath;

	}
}
