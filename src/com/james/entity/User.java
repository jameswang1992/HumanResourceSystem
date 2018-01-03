package com.james.entity;

import java.util.Date;

public class User {

	private Integer userId;
	private String userName;
	private String password;
	private Department uDepartment;
	private Position uPosition;
	private Date entryTime;// 入职时间
	private int userType;// 0：管理员，1：游客，2：员工，3：部门主管，4：离职员工

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String userName, String password, Department uDepartment, Position uPosition,
			Date entryTime, int userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.uDepartment = uDepartment;
		this.uPosition = uPosition;
		this.entryTime = entryTime;
		this.userType = userType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getuDepartment() {
		return uDepartment;
	}

	public void setuDepartment(Department uDepartment) {
		this.uDepartment = uDepartment;
	}

	public Position getuPosition() {
		return uPosition;
	}

	public void setuPosition(Position uPosition) {
		this.uPosition = uPosition;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", uDepartment="
				+ uDepartment + ", uPosition=" + uPosition + ", entryTime=" + entryTime
				+ ", userType=" + userType + "]";
	}

}
