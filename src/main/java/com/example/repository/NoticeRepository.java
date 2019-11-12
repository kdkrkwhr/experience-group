package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer>  {
	
	String noticeAllListQuery = 
			"SELECT "
			+ "notice_no, subject, content, reg_date, file_no  "
			+ "FROM notice";

	@Query(value = noticeAllListQuery, nativeQuery = true)
	public List<Notice> noticeAllList();

}
