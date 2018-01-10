package com.james.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.dao.RecruitmentDao;
import com.james.entity.Recruitment;
import com.james.service.RecruitmentService;

@Service("recmtService")
public class RecruitmentServiceImple implements RecruitmentService {
	
	@Autowired
	private RecruitmentDao recmtDao;
	
	public List<Recruitment> queryAllRecmts() {
		return recmtDao.queryAllRecmts();
	}


	public int insertRecmt(Recruitment recmt) {
		return recmtDao.addRecruitment(recmt);
	}


	public Recruitment queryRecmtByRecmtId(Integer recruitId) {
		return recmtDao.queryRecmtByRecmtId(recruitId);
	}


	public int updateRecmt(Recruitment recmt) {
		return recmtDao.updateRecruitment(recmt);
	}

}
