package com.james.entity;

import java.util.Date;

public class Training {

	private Integer trainId;
	private Department tDept;
	private String trainName;
	private Date trainTime;

	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Training(Integer trainId, Department tDept, String trainName, Date trainTime) {
		super();
		this.trainId = trainId;
		this.tDept = tDept;
		this.trainName = trainName;
		this.trainTime = trainTime;
	}

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Department gettDept() {
		return tDept;
	}

	public void settDept(Department tDept) {
		this.tDept = tDept;
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
		return "Training [trainId=" + trainId + ", tDept=" + tDept + ", trainName=" + trainName + ", trainTime="
				+ trainTime + "]";
	}

}
