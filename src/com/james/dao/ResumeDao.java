package com.james.dao;

import com.james.entity.Resume;

public interface ResumeDao {
	
	int addResume(Resume resume);
	
	int updateResume(Resume resume);
	
	Resume queryResumeByUserId(Integer userId);
	
	
}
