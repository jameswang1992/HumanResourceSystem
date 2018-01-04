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
import com.james.dao.RecruitmentDao;
import com.james.entity.Department;
import com.james.entity.Position;
import com.james.entity.Recruitment;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mybatis.xml","/spring-mvc.xml"})
public class TestRecruitmentDao {
	
	@Autowired
	private RecruitmentDao recmtDao;
	@Autowired
	private DepartmentDao deptDao;
	@Autowired
	private PositionDao posDao;
	
	@Test
	public void testAddRecmt() {
		Department dept = deptDao.queryDepartmentByDeptId(3);
		Position position = posDao.queryPositionByPositionId(2);
		Recruitment recmt = new Recruitment(0, dept, position, "Java开发十年经验", "10000-12000", 0);
		int res = recmtDao.addRecruitment(recmt);
		System.out.println(res);
	}
	
	@Test
	public void updateRecmt() {
		Recruitment recmt = recmtDao.queryRecmtByRecmtId(1);
		recmt.setExpired(0);
		int res = recmtDao.updateRecruitment(recmt);
		System.out.println(res);
	}
	
	@Test
	public void queryRecmtById() {
		Recruitment recmt = recmtDao.queryRecmtByRecmtId(1);
		System.out.println(recmt);
	}
	
	@Test
	public void queryAll() {
		List<Recruitment> list = recmtDao.queryAllRecmts();
		System.out.println(list);
	}
}


































