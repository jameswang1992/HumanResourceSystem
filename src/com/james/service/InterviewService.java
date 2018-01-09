package com.james.service;


import com.james.entity.Interview;

public interface InterviewService {
	
	int insertIV(Interview interview);
	
	Interview queryIVByUserId(Integer userId);
	
}
