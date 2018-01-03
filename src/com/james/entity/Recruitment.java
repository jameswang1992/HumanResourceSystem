package com.james.entity;

/**
 * ��Ƹ��Ϣ��
 * @author jameswang
 *
 */
public class Recruitment {

	private Integer recruitId;
	private Department rDepartment;
	private Position rPosition;
	private String requirement;
	private String treatment;// н�ʴ���
	private int expired;// 0��û����ְ��1����������ְ

	public Recruitment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recruitment(Integer recruitId, Department rDepartment, Position rPosition, String requirement,
			String treatment, int expired) {
		super();
		this.recruitId = recruitId;
		this.rDepartment = rDepartment;
		this.rPosition = rPosition;
		this.requirement = requirement;
		this.treatment = treatment;
		this.expired = expired;
	}

	public Integer getRecruitId() {
		return recruitId;
	}

	public void setRecruitId(Integer recruitId) {
		this.recruitId = recruitId;
	}

	public Department getrDepartment() {
		return rDepartment;
	}

	public void setrDepartment(Department rDepartment) {
		this.rDepartment = rDepartment;
	}

	public Position getrPosition() {
		return rPosition;
	}

	public void setrPosition(Position rPosition) {
		this.rPosition = rPosition;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public int getExpired() {
		return expired;
	}

	public void setExpired(int expired) {
		this.expired = expired;
	}

	@Override
	public String toString() {
		return "Recruitment [recruitId=" + recruitId + ", rDepartment=" + rDepartment.getDeptName() + ", rPosition=" + rPosition.getPositionName()
				+ ", requirement=" + requirement + ", treatment=" + treatment + ", expired=" + expired + "]";
	}

}
