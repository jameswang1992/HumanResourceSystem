package com.james.testdao;




import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.james.dao.DepartmentDao;
import com.james.dao.PositionDao;
import com.james.dao.ResumeDao;
import com.james.dao.UserDao;
import com.james.entity.Department;
import com.james.entity.Position;
import com.james.entity.Resume;
import com.james.entity.User;







@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mybatis.xml","/spring-mvc.xml"})
public class TestResumeDao {
	
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private DepartmentDao deptDao;
	@Autowired
	private PositionDao posDao;
	
	@Test
	public void testAddResume() {
		User user = userDao.queryUserByUserId(4);
		Department dept = deptDao.queryDepartmentByDeptId(3);
		Position position = posDao.queryPositionByPositionId(2);
		Resume resume = new Resume(0, user, "王二", 25, 13808888888L, "男", "本科", "123@mail.com", "妇联主席", 1, "篮球", "经理", "3000-4000", dept, position,"未查看");
		int res = resumeDao.addResume(resume);
		System.out.println(res);
	}
	
	@Test
	public void testQueryResumeByUserId() {
		Resume resume = resumeDao.queryResumeByUserId(4);
		System.out.println(resume);
	}
	
	@Test
	public void testUpdateResume() {
		Resume resume = resumeDao.queryResumeByUserId(4);
		resume.setContact(1334445555L);
		resume.setAge(20);
		resume.setHobby("跑步");
		int res = resumeDao.updateResume(resume);
		System.out.println(res);
	}
	
}


































