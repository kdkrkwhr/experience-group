package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.ExpMember;

@Repository
public interface ExpMemberRepository  extends JpaRepository<ExpMember, Integer>  {

	String expListQuery = "SELECT " + 
			"member_no," + 
			"experience_no," + 
			"blog_address," + 
			"email,\r\n" + 
			"name,\r\n" + 
			"phone,\r\n" + 
			"address,\r\n" + 
			"prd_name,\r\n" + 
			"memo\r\n" + 
			"FROM exp_member\r\n" + 
			"WHERE experience_no = 1;";

	@Query(value = expListQuery, nativeQuery = true)
	public List<ExpMember> ExpList();

}
