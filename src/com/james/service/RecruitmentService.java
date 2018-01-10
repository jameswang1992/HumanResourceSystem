package com.james.service;

import java.util.List;

import com.james.entity.Recruitment;

public interface RecruitmentService {
	
	List<Recruitment> queryAllRecmts();
	
	int insertRecmt(Recruitment recmt);
	
	int updateRecmt(Recruitment recmt);
	
	Recruitment queryRecmtByRecmtId(Integer recruitId);
}
