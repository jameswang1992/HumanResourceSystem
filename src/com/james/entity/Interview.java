package com.james.entity;

import java.util.Date;

/**
 * 面试类
 * 
 * @author jameswang
 *
 */
public class Interview {

	private Integer interviewId;
	private Date interTime;// 面试时间
	private String interAddress;// 面试地点
	private Application iApp;// 关联应聘信息
	private String isHire;// 是否录用

	public Interview() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Interview(Integer interviewId, Date interTime, String interAddress, Application iApp, String isHire) {
		super();
		this.interviewId = interviewId;
		this.interTime = interTime;
		this.interAddress = interAddress;
		this.iApp = iApp;
		this.isHire = isHire;
	}

	public Integer getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}

	public Date getInterTime() {
		return interTime;
	}

	public void setInterTime(Date interTime) {
		this.interTime = interTime;
	}

	public String getInterAddress() {
		return interAddress;
	}

	public void setInterAddress(String interAddress) {
		this.interAddress = interAddress;
	}

	public Application getiApp() {
		return iApp;
	}

	public void setiApp(Application iApp) {
		this.iApp = iApp;
	}

	public String getIsHire() {
		return isHire;
	}

	public void setIsHire(String isHire) {
		this.isHire = isHire;
	}

	@Override
	public String toString() {
		return "Interview [interviewId=" + interviewId + ", interTime=" + interTime + ", interAddress=" + interAddress
				+ ", iApp=" + iApp + ", isHire=" + isHire + "]";
	}

}
