package com.james.testdao;




import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.james.dao.DepartmentDao;
import com.james.dao.TrainingDao;
import com.james.entity.Department;
import com.james.entity.Training;







@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mybatis.xml","/spring-mvc.xml"})
public class TestTrainingDao {
	
	@Autowired
	private TrainingDao trainDao;
	@Autowired
	private DepartmentDao deptDao;
	
	@Test
	public void testAddTrain() {
		Department dept = deptDao.queryDepartmentByDeptId(1);
		Training train = new Training(-1, dept, "java¿ª·¢ÅàÑµ", new Date());
		int res = trainDao.addTraining(train);
		System.out.println(res);
	}
	
	
	@Test
	public void testQuery() {
		Training trainingByDeptId = trainDao.queryTrainingByDeptId(1);
		System.out.println(trainingByDeptId);
	}
}


































