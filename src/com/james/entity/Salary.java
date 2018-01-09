package com.james.entity;

/**
 * 工资类
 * 
 * @author jameswang
 *
 */
public class Salary {

	private Integer salaryId;
	private User sUser;
	private Bonusmalus bm;// 奖惩工资
	private double basicSalary;
	private double overSalary;// 绩效工资
	private double socialInsurance;// 社保
	private double totalSalary;
	private int sYear;
	private int sMonth;

	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Salary(Integer salaryId, User sUser, Bonusmalus bm, double basicSalary, double overSalary,
			double socialInsurance, double totalSalary, int sYear, int sMonth) {
		super();
		this.salaryId = salaryId;
		this.sUser = sUser;
		this.bm = bm;
		this.basicSalary = basicSalary;
		this.overSalary = overSalary;
		this.socialInsurance = socialInsurance;
		this.setTotalSalary(totalSalary);
		this.sYear = sYear;
		this.sMonth = sMonth;
	}



	public Integer getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(Integer salaryId) {
		this.salaryId = salaryId;
	}

	public User getsUser() {
		return sUser;
	}

	public void setsUser(User sUser) {
		this.sUser = sUser;
	}

	public Bonusmalus getBm() {
		return bm;
	}

	public void setBm(Bonusmalus bm) {
		this.bm = bm;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getOverSalary() {
		return overSalary;
	}

	public void setOverSalary(double overSalary) {
		this.overSalary = overSalary;
	}

	public double getSocialInsurance() {
		return socialInsurance;
	}

	public void setSocialInsurance(double socialInsurance) {
		this.socialInsurance = socialInsurance;
	}

	public int getsYear() {
		return sYear;
	}

	public void setsYear(int sYear) {
		this.sYear = sYear;
	}

	public int getsMonth() {
		return sMonth;
	}

	public void setsMonth(int sMonth) {
		this.sMonth = sMonth;
	}


	public double getTotalSalary() {
		double totalSalary = basicSalary+overSalary+socialInsurance;
		return totalSalary;
	}



	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}



	@Override
	public String toString() {
		return "Salary [salaryId=" + salaryId + ", sUser=" + sUser + ", bm=" + bm + ", basicSalary=" + basicSalary
				+ ", overSalary=" + overSalary + ", socialInsurance=" + socialInsurance + ", totalSalary=" + totalSalary
				+ ", sYear=" + sYear + ", sMonth=" + sMonth + "]";
	}
	
	

}
