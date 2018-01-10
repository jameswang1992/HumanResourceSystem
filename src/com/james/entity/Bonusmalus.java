package com.james.entity;

import java.util.Date;

/**
 * Ω±≥Õ¿‡
 * 
 * @author jameswang
 *
 */
public class Bonusmalus {

	private Integer bmId;
	private User bUser;
	private double bmSalary;
	private String bmReason;
	private Date bmTime;
	private String bmType;// Ω±¿¯£¨≥Õ∑£

	public Bonusmalus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bonusmalus(Integer bmId, User bUser, double bmSalary, String bmReason, Date bmTime, String bmType) {
		super();
		this.bmId = bmId;
		this.bUser = bUser;
		this.bmSalary = bmSalary;
		this.bmReason = bmReason;
		this.bmTime = bmTime;
		this.bmType = bmType;
	}

	public Integer getBmId() {
		return bmId;
	}

	public void setBmId(Integer bmId) {
		this.bmId = bmId;
	}

	public User getbUser() {
		return bUser;
	}

	public void setbUser(User bUser) {
		this.bUser = bUser;
	}

	public double getBmSalary() {
		return bmSalary;
	}

	public void setBmSalary(double bmSalary) {
		this.bmSalary = bmSalary;
	}

	public String getBmReason() {
		return bmReason;
	}

	public void setBmReason(String bmReason) {
		this.bmReason = bmReason;
	}

	public Date getBmTime() {
		return bmTime;
	}

	public void setBmTime(Date bmTime) {
		this.bmTime = bmTime;
	}

	public String getBmType() {
		return bmType;
	}

	public void setBmType(String bmType) {
		this.bmType = bmType;
	}

	@Override
	public String toString() {
		return "Bonusmalus [bmId=" + bmId + ", bUser=" + bUser + ", bmSalary=" + bmSalary + ", bmReason=" + bmReason
				+ ", bmTime=" + bmTime + ", bmType=" + bmType + "]";
	}

	

}
