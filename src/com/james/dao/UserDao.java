package com.james.dao;

import java.util.List;



import org.apache.ibatis.annotations.Param;


import com.james.entity.User;

public interface UserDao {
	
	int addUser(User user);
	
	List<User> queryAllUsers();
	
	User queryUserByUserId(Integer userId);
	
	User queryTouristByUserId(Integer userId);
	
	User queryUserByUserNameAndPassword(@Param(value = "userName") String userName, @Param(value = "password") String password);
	
	User queryUserByUserName(String userName);
	
	List<User> queryUsersByUserType();//Ô±¹¤ÊÇ2
	
	List<User> queryUsersByDeptId(Integer deptId);
	
	List<User> queryUsersByPositionId(Integer positionId);
	
	int updateUser(User user);
}





















