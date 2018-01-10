package com.james.service;


import java.util.List;

import com.james.entity.Interview;

public interface InterviewService {
	
	int insertIV(Interview interview);
	
	Interview queryIVByUserId(Integer userId);
	
	List<Interview> queryIVsByDeptId(Integer deptId);
}
