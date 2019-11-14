package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ExpMember;

@Repository
public interface ExpMemberRepository  extends JpaRepository<ExpMember, Integer>  {

}
