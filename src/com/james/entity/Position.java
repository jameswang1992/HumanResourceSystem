package com.james.entity;

import java.util.Date;

public class Position {

	private Integer positionId;
	private String positionName;
	private Department pDepartment;
	private Date positCreateTime;

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(Integer positionId, String positionName, Department pDepartment, Date positCreateTime) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
		this.pDepartment = pDepartment;
		this.positCreateTime = positCreateTime;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Department getpDepartment() {
		return pDepartment;
	}

	public void setpDepartment(Department pDepartment) {
		this.pDepartment = pDepartment;
	}

	public Date getPositCreateTime() {
		return positCreateTime;
	}

	public void setPositCreateTime(Date positCreateTime) {
		this.positCreateTime = positCreateTime;
	}

	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", positionName=" + positionName + ", pDepartment=" + pDepartment.getDeptName()
				+ ", positCreateTime=" + positCreateTime + "]";
	}

}
