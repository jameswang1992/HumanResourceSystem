package com.james.testdao;




import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.james.dao.UserDao;
import com.james.entity.Department;
import com.james.entity.Position;
import com.james.entity.User;






@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mybatis.xml","/spring-mvc.xml"})
public class TestUserDao {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testAddUser() {
		Department dept = new Department(1, "人事部",new Date());
		Position position = new Position(1, "主管", dept,new Date());
		User user = new User(0, "111", "111", dept, position, new Date(), 0);
		int res = userDao.addUser(user);
		System.out.println(res);
	}
	
	@Test
	public void testQueryUserById() {
		User user = userDao.queryTouristByUserId(8);
		System.out.println(user);
	}
	
	@Test
	public void testQueryUserByName() {
		User user = userDao.queryUserByUserName("111");
		System.out.println(user);
	}
	
	@Test
	public void testQueryUserByNameAndPassword() {
		User user = userDao.queryUserByUserNameAndPassword("111","111");
		System.out.println(user);
	}
	
	@Test
	public void testQueryAllUsers() {
		List<User> users = userDao.queryAllUsers();
		System.out.println(users);
	}
	
	@Test
	public void testUpdateUser() {
		Department dept = new Department(1, "人事部",new Date());
		Position position = new Position(1, "主管", dept,new Date());
		User user = new User(4, "222", "222", dept, position, new Date(), 1);
		int res = userDao.updateUser(user);
		System.out.println(res);
	}
	
	@Test
	public void testQueryUsersByType() {
		List<User> users = userDao.queryUsersByUserType();
		System.out.println(users);
	}
	
}


































