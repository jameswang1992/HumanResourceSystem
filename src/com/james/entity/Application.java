package com.james.entity;

import java.util.Date;

/**
 * ӦƸ��
 * 
 * @author jameswang
 *
 */
public class Application {

	private Integer appId;
	private User aUser;
	private Recruitment aRecmt;
	private Date appCreateTime;// ����Ͷ��ʱ��
	private String status;// ӦƸ��Ϣ�鿴״̬

	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Application(Integer appId, User aUser, Recruitment aRecmt, Date appCreateTime, String status) {
		super();
		this.appId = appId;
		this.aUser = aUser;
		this.aRecmt = aRecmt;
		this.appCreateTime = appCreateTime;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Application [appId=" + appId + ", aUser=" + aUser + ", aRecmt=" + aRecmt + ", appCreateTime="
				+ appCreateTime + ", status=" + status + "]";
	}

}
