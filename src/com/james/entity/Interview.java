package com.james.entity;

import java.util.Date;

/**
 * ������
 * 
 * @author jameswang
 *
 */
public class Interview {

	private Integer interviewId;
	private Date interTime;// ����ʱ��
	private String interAddress;// ���Եص�
	private Application iApp;// ����ӦƸ��Ϣ
	private String isHire;// �Ƿ�¼��

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
