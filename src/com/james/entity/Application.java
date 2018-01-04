package com.james.entity;

import java.util.Date;

/**
 * 应聘类
 * 
 * @author jameswang
 *
 */
public class Application {

	private Integer appId;
	private User aUser;
	private Recruitment aRecmt;
	private Date appCreateTime;// 简历投递时间

	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Application(Integer appId, User aUser, Recruitment aRecmt, Date appCreateTime) {
		super();
		this.appId = appId;
		this.aUser = aUser;
		this.aRecmt = aRecmt;
		this.appCreateTime = appCreateTime;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public User getaUser() {
		return aUser;
	}

	public void setaUser(User aUser) {
		this.aUser = aUser;
	}

	public Recruitment getaRecmt() {
		return aRecmt;
	}

	public void setaRecmt(Recruitment aRecmt) {
		this.aRecmt = aRecmt;
	}

	public Date getAppCreateTime() {
		return appCreateTime;
	}

	public void setAppCreateTime(Date appCreateTime) {
		this.appCreateTime = appCreateTime;
	}

	@Override
	public String toString() {
		return "Application [appId=" + appId + ", aUser=" + aUser + ", aRecmt=" + aRecmt + ", appCreateTime="
				+ appCreateTime + "]";
	}

}
