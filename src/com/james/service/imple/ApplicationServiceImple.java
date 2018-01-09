package com.james.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.dao.ApplicationDao;
import com.james.entity.Application;
import com.james.service.ApplicationService;

@Service("appService")
public class ApplicationServiceImple implements ApplicationService {
	
	@Autowired
	private ApplicationDao appDao;
	

	public int insertApp(Application application) {
		return appDao.addApplication(application);
	}


	public List<Application> queryAllApplications() {
		return appDao.queryAllApplications();
	}


	public Application queryAppByUserId(Integer userId) {
		return appDao.queryApplicationByUserId(userId);
	}


	public int updateAppStatus(Application application) {
		return appDao.updateAppStatus(application);
	}

}
