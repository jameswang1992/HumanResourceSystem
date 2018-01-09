package com.james.service;

import java.util.List;

import com.james.entity.Application;

public interface ApplicationService {
	
	int insertApp(Application application);
	
	List<Application> queryAllApplications();
	
	Application queryAppByUserId(Integer userId);
	
	int updateAppStatus(Application application);
}
