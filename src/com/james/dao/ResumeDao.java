package com.james.dao;

import com.james.entity.Resume;

public interface ResumeDao {
	
	int addResume(Resume resume);
	
	int updateResume(Resume resume);
	
	/**
	 * �����û�ID��������Ӧ�ļ���
	 * @param userId
	 * @return
	 */
	Resume queryResumeByUserId(Integer userId);
	
	
}
