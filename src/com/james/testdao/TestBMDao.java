package com.james.testdao;




import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.james.dao.BonusmalusDao;
import com.james.dao.SalaryDao;
import com.james.dao.UserDao;
import com.james.entity.Bonusmalus;
import com.james.entity.Department;
import com.james.entity.Position;
import com.james.entity.Salary;
import com.james.entity.User;






@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mybatis.xml","/spring-mvc.xml"})
public class TestBMDao {
	
	@Autowired
	private BonusmalusDao bmDao;
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testAddBM() {
		User user = userDao.queryUserByUserId(3);
		Bonusmalus bm = new Bonusmalus(-1, user, 200, "±íÏÖºÃ", new Date(), "½±Àø");
		int res = bmDao.addBonusmalus(bm);
		System.out.println(res);
	}
	
	@Test
	public void testQueryByUserId() {
		List<Bonusmalus> bms = bmDao.queryBMsbyUserId(3);
		System.out.println(bms);
	}
	
	@Test
	public void testQueryByDate() {
		List<Bonusmalus> bms = bmDao.queryBMsByDate(2018, 1);
		System.out.println(bms);
	}
	
	
	
}


































