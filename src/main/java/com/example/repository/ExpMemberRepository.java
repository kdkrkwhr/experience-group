package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.ExpMember;

@Repository
public interface ExpMemberRepository  extends JpaRepository<ExpMember, Integer>  {

	String expListQuery = 
			" SELECT " + 
			"     member_no," + 
			"     experience_no," + 
			"     blog_address," + 
			"     email," + 
			"     name," + 
			"     phone," + 
			"     address," + 
			"     prd_name," + 
			"     memo" + 
			" FROM exp_member" + 
			" WHERE experience_no = :experienceNo";

	String expCntUpQuery = 
			" UPDATE experience " + 
			" SET appli_cnt = ifnull(appli_cnt, 0) + 1" + 
			" WHERE experience_no = :experienceNo";

	@Query(value = expListQuery, nativeQuery = true)
	public List<ExpMember> expList(@Param("experienceNo") int experienceNo);

	@Modifying
	@Transactional
	@Query(value = expCntUpQuery, nativeQuery = true)
	public void expCntUp(@Param("experienceNo") int experienceNo);

}
