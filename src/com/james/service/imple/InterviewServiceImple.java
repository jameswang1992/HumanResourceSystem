package com.james.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.dao.InterviewDao;
import com.james.entity.Interview;
import com.james.service.InterviewService;

@Service("ivService")
public class InterviewServiceImple implements InterviewService {
	
	@Autowired
	private InterviewDao ivDao;
	

	public int insertIV(Interview interview) {
		return ivDao.addInterview(interview);
	}

	public Interview queryIVByUserId(Integer userId) {
		return ivDao.queryInterviewByUserId(userId);
	}


	public List<Interview> queryIVsByDeptId(Integer deptId) {
		return ivDao.queryIVsByDeptId(deptId);
	}

}
