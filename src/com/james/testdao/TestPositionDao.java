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
import com.james.entity.Department;
import com.james.entity.Position;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mybatis.xml","/spring-mvc.xml"})
public class TestPositionDao {
	
	@Autowired
	private PositionDao posDao;
	@Autowired
	private DepartmentDao deptDao;
	
	@Test
	public void testAddPosition() {
		Department dept = deptDao.queryDepartmentByDeptId(1);
		Position position = new Position(-1, "ְԱ", dept, new Date());
		int res = posDao.addPosition(position);
		System.out.println(res);
	}
	
	
	@Test
	public void testQueryPositionByDeptId() {
		List<Position> poss = posDao.queryPositionsByDeptId(1);
		System.out.println(poss);
	}
	
	@Test
	public void testQueryPositionByPid() {
		Position p = posDao.queryPositionByPositionId(1);
		System.out.println(p);
	}
	
	
}


































