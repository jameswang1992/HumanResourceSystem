package com.james.entity;

/**
 * “Ï“È¿‡
 * 
 * @author jameswang
 *
 */
public class Dispute {

	private Integer disputeId;
	private User user;
	private Salary salary;
	private String disputeReason;

	public Dispute() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dispute(Integer disputeId, User user, Salary salary, String disputeReason) {
		super();
		this.disputeId = disputeId;
		this.user = user;
		this.salary = salary;
		this.disputeReason = disputeReason;
	}

	public Integer getDisputeId() {
		return disputeId;
	}

	public void setDisputeId(Integer disputeId) {
		this.disputeId = disputeId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public String getDisputeReason() {
		return disputeReason;
	}

	public void setDisputeReason(String disputeReason) {
		this.disputeReason = disputeReason;
	}

	@Override
	public String toString() {
		return "Dispute [disputeId=" + disputeId + ", user=" + user + ", salary=" + salary + ", disputeReason="
				+ disputeReason + "]";
	}

}
