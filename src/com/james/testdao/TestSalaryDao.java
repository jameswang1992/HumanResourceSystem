package com.james.testdao;




import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.james.dao.SalaryDao;
import com.james.dao.UserDao;
import com.james.entity.Department;
import com.james.entity.Position;
import com.james.entity.Salary;
import com.james.entity.User;






@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mybatis.xml","/spring-mvc.xml"})
public class TestSalaryDao {
	
	@Autowired
	private SalaryDao salaryDao;
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testAddSalary() {
		User user = userDao.queryUserByUserId(8);
		Salary s = new Salary(-1, user, 1000, 500, -300, 200,2018, 1);
		int res = salaryDao.addSalary(s);
		System.out.println(res);
	}
	
	@Test
	public void testQuerySalary() {
		List<Salary> salaries = salaryDao.querySalariesByDate(2018, 1);
		System.out.println(salaries);
	}
	
	@Test
	public void testQuerySalaryByUserId() {
		List<Salary> salaries = salaryDao.querySalaryByUserId(8);
		System.out.println(salaries);
	}
	
	@Test
	public void testQuerySalaryByUserIdAndDate() {
		Salary s = salaryDao.querySalaryByUserIdAndDate(8, 2018, 1);
		System.out.println(s);
	}
	
	
}


































