package com.james.testdao;




import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.james.dao.DepartmentDao;

import com.james.entity.Department;







@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mybatis.xml","/spring-mvc.xml"})
public class TestDeptDao {
	
	@Autowired
	private DepartmentDao deptDao;
	
	@Test
	public void testAddDept() {
		Department dept = new Department(0, "行政部", new Date());
		int res = deptDao.addDepartment(dept);
		System.out.println(res);
	}
	
	@Test
	public void testQueryDept() {
		List<Department> depts = deptDao.queryAllDepartments();
		System.out.println(depts);
	}
	
	@Test
	public void testQueryDeptById() {
		Department dept = deptDao.queryDepartmentByDeptId(3);
		System.out.println(dept);
	}
	
	@Test
	public void testUpdate() {
		Department dept = new Department(1, "销售部", new Date());
		int res = deptDao.updateDepartment(dept);
		System.out.println(res);
	}
	
}


































