package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>  {
	
	String EXP_SELECT_5 =
			"	SELECT TOP 5"
					+ "		BOARD_NO"
					+ "		,SUBJECT"
					+ "		,TYPE"
					+ "		,APPLI_CNT"
					+ "		,RECRUT_CNT"
					+ "		,REG_DATE"
					+ "		,PRD_NAME"
					+ "		,CONTENT"
					+ "	FROM"
					+ "		EXP_BOARD"
					+ "	ORDER BY BOARD_NO ASC";
	
	String EXP_SELECT_10 =
			"	SELECT TOP 10"
					+ "		BOARD_NO"
					+ "		,SUBJECT"
					+ "		,TYPE"
					+ "		,APLI_CNT"
					+ "		,RECRUT_CNT"
					+ "		,REG_DATE"
					+ "	FROM"
					+ "		EXP_BOARD"
					+ "	ORDER BY BOARD_NO ASC";
	
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

}
