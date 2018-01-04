package com.james.dao;

import java.util.List;

import com.james.entity.Application;

public interface ApplicationDao {
	
	int addApplication(Application app);
	
	int deleteApplication(Integer appId);
	
	List<Application> queryAllApplications();
	
	Application queryApplicationByUserId(Integer userId);
	
}
