package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>  {
	
	String EXP_SELECT_5 =
			"	SELECT"
					+ "		experience_no"
					+ "		,subject"
					+ "		,type"
					+ "		,appli_cnt"
					+ "		,recrut_cnt"
					+ "		,reg_date"
					+ "		,prd_name"
					+ "		,content"
					+ "	FROM"
					+ "		experience"
					+ "	ORDER BY experience_no DESC";
	
	String EXP_SELECT_10 =
			"	SELECT"
					+ "		experience_no"
					+ "		,subject"
					+ "		,type"
					+ "		,appli_cnt"
					+ "		,recrut_cnt"
					+ "		,reg_date"
					+ "		,prd_name"
					+ "		,content"
					+ "	FROM"
					+ "		experience"
					+ "	ORDER BY experience_no DESC";
	
	String EXP_SELECT_1 = 
			"	SELECT experience_no"
			+ "		,subject"
			+ "		,type"
			+ "		,appli_cnt"
			+ "		,recrut_cnt"
			+ "		,reg_date"
			+ "		,prd_name"
			+ "		,content"
			+ "	FROM experience"
			+ "	WHERE experience_no = :idx";
	/**
	 * 메인 게시글 5개 SELECT
	 */
	@Query(value = EXP_SELECT_5, nativeQuery = true)
	List<Experience> mainBoardSelect();
	
	/**
	 * 동기와 상의할 신청목록 게시글 (페이징)
	 * @return
	 */
	@Query(value = EXP_SELECT_10, nativeQuery = true)
	List<Experience> ExperienceBoardSelect();

	
	/**
	 * 게시글 한 개 정보 가져오기
	 */
	@Query(value = EXP_SELECT_1, nativeQuery = true)
	Experience selectOne(@Param("idx") int idx);
}
