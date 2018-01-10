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
import com.james.dao.InterviewDao;
import com.james.dao.RecruitmentDao;
import com.james.entity.Application;
import com.james.entity.Department;
import com.james.entity.Interview;
import com.james.entity.Position;
import com.james.entity.Recruitment;
import com.james.entity.User;







@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mybatis.xml","/spring-mvc.xml"})
public class TestInterviewDao {
	
	@Autowired
	private InterviewDao interDao;
	@Autowired
	private ApplicationDao appDao;
	@Autowired
	private RecruitmentDao recmtDao;
	
	@Test
	public void testAddInter() {
		Application app = appDao.queryApplicationByUserId(4);
		Interview iv = new Interview(0, new Date(), "ÉÏº£", app, "Î´Â¼ÓÃ");
		int res = interDao.addInterview(iv);
		System.out.println(res);
	}
	
	@Test
	public void testQueryInterview() {
		Interview iv = interDao.queryInterviewByUserId(9);
		User user = iv.getiApp().getaUser();
		Recruitment recmt1 = iv.getiApp().getaRecmt();
		Application app = iv.getiApp();
		Recruitment recmt = recmtDao.queryRecmtByRecmtId(recmt1.getRecruitId());
		System.out.println(recmt);
		Department dept = recmt.getrDepartment();
		Position position = recmt.getrPosition();
		System.out.println(user);
		System.out.println(dept);
		System.out.println(position);
		System.out.println(app);
	}
	
	@Test
	public void testQueryInterviewByDeptId() {
		List<Interview> ivs = interDao.queryIVsByDeptId(4);
		System.out.println(ivs);
	}
	
}


































