package com.james.dao;

import java.util.List;

import com.james.entity.Application;

public interface ApplicationDao {
	
	int addApplication(Application application);
	
	int deleteApplication(Integer appId);
	
	int updateAppStatus(Application application);
	
	List<Application> queryAllApplications();
	
	Application queryApplicationByUserId(Integer userId);
	
}
