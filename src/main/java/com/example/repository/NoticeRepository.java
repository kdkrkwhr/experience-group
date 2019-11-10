package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer>  {
	
	String query1 = "select 1";
	
	@Query(value = query1, nativeQuery = true)
	public int test();

}
