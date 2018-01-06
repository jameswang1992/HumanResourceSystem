package com.james.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.dao.ResumeDao;
import com.james.entity.Resume;
import com.james.service.ResumeService;

@Service("resumeService")
public class ResumeServiceImple implements ResumeService {
	
	@Autowired
	private ResumeDao resumeDao;
	

	public int insertResume(Resume resume) {
		return resumeDao.addResume(resume);
	}

	
	public int modifyResume(Resume resume) {
		return resumeDao.updateResume(resume);
	}


	public Resume queryResumeByUserId(Integer userId) {
		return resumeDao.queryResumeByUserId(userId);
	}

}
