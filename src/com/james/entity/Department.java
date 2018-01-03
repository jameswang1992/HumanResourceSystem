package com.james.entity;

import java.util.Date;

public class Department {

	private Integer deptId;
	private String deptName;
	private Date deptCreateTime;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Integer deptId, String deptName, Date deptCreateTime) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptCreateTime = deptCreateTime;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Date getDeptCreateTime() {
		return deptCreateTime;
	}

	public void setDeptCreateTime(Date deptCreateTime) {
		this.deptCreateTime = deptCreateTime;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptCreateTime=" + deptCreateTime + "]";
	}

}