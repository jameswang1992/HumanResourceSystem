package com.james.dao;

import java.util.List;

import com.james.entity.Interview;

public interface InterviewDao {
	
	int addInterview(Interview interview);
	
	int deleteInterview(Integer interviewId);
	
	Interview queryInterviewByUserId(Integer userId);
	
	List<Interview> queryIVsByDeptId(Integer deptId);
}
