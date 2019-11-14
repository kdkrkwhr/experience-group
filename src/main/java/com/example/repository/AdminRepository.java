package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>  {

	String loginQuery = 
			" SELECT " + 
			"   admin_email, admin_password " + 
			" FROM " + 
			"   ADMIN " + 
			" WHERE " + 
			"   admin_email = :adminEmail AND admin_password = :adminPassword";

	@Query(value = loginQuery, nativeQuery = true)
	Admin adminLogin(@Param("adminEmail") String adminEmail, @Param("adminPassword") String adminPassword);
}
