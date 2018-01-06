package com.james.service;

import java.util.List;

import com.james.entity.Recruitment;

public interface RecruitmentService {
	
	List<Recruitment> queryAllRecmts();
	
	int insertRecmt(Recruitment recmt);
	
	Recruitment queryRecmtByRecmtId(Integer recruitId);
}
