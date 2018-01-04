package com.james.dao;

import com.james.entity.Resume;

public interface ResumeDao {
	
	int addResume(Resume resume);
	
	int updateResume(Resume resume);
	
	/**
	 * 根据用户ID查找所对应的简历
	 * @param userId
	 * @return
	 */
	Resume queryResumeByUserId(Integer userId);
	
	
}
