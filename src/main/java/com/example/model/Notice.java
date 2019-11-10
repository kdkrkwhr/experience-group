package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.model.Board.BoardBuilder;

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

	@Column(insertable=false, updatable=false)
	private int fileNo;

	@Builder
	public Notice(String subject, String content, String regDate, int fileNo) {

		this.subject = subject;
		this.content = content;
		this.regDate = regDate;
		this.fileNo = fileNo;

	}
}
