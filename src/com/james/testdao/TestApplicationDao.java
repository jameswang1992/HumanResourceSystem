package com.james.testdao;




import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.james.dao.ApplicationDao;
import com.james.dao.DepartmentDao;
import com.james.dao.RecruitmentDao;
import com.james.dao.UserDao;
import com.james.entity.Application;
import com.james.entity.Department;
import com.james.entity.Recruitment;
import com.james.entity.User;







@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mybatis.xml","/spring-mvc.xml"})
public class TestApplicationDao {
	
	@Autowired
	private ApplicationDao appDao;
	@Autowired
	private RecruitmentDao recmtDao;
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testAddDept() {
		User user = userDao.queryUserByUserId(4);
		Recruitment recmt = recmtDao.queryRecmtByRecmtId(1);
		Application app = new Application(0, user, recmt, new Date());
		int res = appDao.addApplication(app);
		System.out.println(res);
		
	}
	
	@Test
	public void testQueryAllApps() {
		List<Application> list = appDao.queryAllApplications();
		System.out.println(list);
	}
	
}


































