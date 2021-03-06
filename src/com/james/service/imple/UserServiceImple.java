package com.james.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.dao.UserDao;
import com.james.entity.User;
import com.james.service.UserService;

@Service("userService")
public class UserServiceImple implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	public int register(String userName, String password) {
		User user = new User(-1, userName, password, null, null, null, 1);//1��ʾ�ο�
		int res = userDao.addUser(user);
		return res;
	}

	
	public User login(String userName, String password) {
		User user = userDao.queryUserByUserNameAndPassword(userName, password);
		return user;
	}


	public User queryUserByUserName(String userName) {
		User user = userDao.queryUserByUserName(userName);
		return user;
	}



	public int modifyUser(User user) {
		return userDao.updateUser(user);
	}


	public User queryUserByUserId(Integer userId) {
		return userDao.queryUserByUserId(userId);
	}


	public List<User> queryUsersByUserType() {
		return userDao.queryUsersByUserType();
	}


	public List<User> queryUsersByDeptId(Integer deptId) {
		return userDao.queryUsersByDeptId(deptId);
	}


	public List<User> queryUsersByPositionId(Integer positionId) {
		return userDao.queryUsersByPositionId(positionId);
	}

}
