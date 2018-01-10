package com.james.service;

import java.util.List;

import com.james.entity.User;

public interface UserService {
	
	int register(String userName,String password);
	
	User login(String userName,String password);
	
	User queryUserByUserName(String userName);
	
	User queryUserByUserId(Integer userId);
	
	int modifyUser(User user);
	
	List<User> queryUsersByUserType();
}
