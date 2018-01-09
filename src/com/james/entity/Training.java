package com.james.entity;

import java.util.Date;

public class Training {

	private Integer trainId;
	private Department dept;
	private String trainName;
	private Date trainTime;

	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Training(Integer trainId, Department dept, String trainName, Date trainTime) {
		super();
		this.trainId = trainId;
		this.dept = dept;
		this.trainName = trainName;
		this.trainTime = trainTime;
	}

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public Date getTrainTime() {
		return trainTime;
	}

	public void setTrainTime(Date trainTime) {
		this.trainTime = trainTime;
	}

	@Override
	public String toString() {
		return "Training [trainId=" + trainId + ", dept=" + dept + ", trainName=" + trainName + ", trainTime="
				+ trainTime + "]";
	}

}
