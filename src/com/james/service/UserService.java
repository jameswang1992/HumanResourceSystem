package com.james.service;

import com.james.entity.User;

public interface UserService {
	
	int register(String userName,String password);
	
	User login(String userName,String password);
	
	User queryUserByUserName(String userName);
	
	int modifyUser(User user);
}
