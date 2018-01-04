package com.james.dao;

import java.util.List;

import com.james.entity.Recruitment;

public interface RecruitmentDao {
	
	int addRecruitment(Recruitment recmt);
	
	int updateRecruitment(Recruitment recmt);
	
	List<Recruitment> queryAllRecmts();
	
	Recruitment queryRecmtByRecmtId(Integer recruitId);
	
	
}	
