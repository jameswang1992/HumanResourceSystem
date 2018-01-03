package com.james.entity;

public class Position {

	private Integer positionId;
	private String positionName;
	private Department pDepartment;

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(Integer positionId, String positionName, Department pDepartment) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
		this.pDepartment = pDepartment;
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

	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", positionName=" + positionName + ", pDepartment=" + pDepartment
				+ "]";
	}

}
