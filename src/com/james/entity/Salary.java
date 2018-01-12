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
	private double basicSalary;
	private double overSalary;// 绩效工资
	private double socialInsurance;// 社保
	private double bonusMalus;//奖惩
	private double totalSalary;//总工资
	private int sYear;
	private int sMonth;

	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salary(Integer salaryId, User sUser, double basicSalary, double overSalary, double socialInsurance,
			double bonusMalus, int sYear, int sMonth) {
		super();
		this.salaryId = salaryId;
		this.sUser = sUser;
		this.basicSalary = basicSalary;
		this.overSalary = overSalary;
		this.socialInsurance = socialInsurance;
		this.bonusMalus = bonusMalus;
		this.totalSalary = basicSalary+overSalary+socialInsurance+bonusMalus;
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

	public double getBonusMalus() {
		return bonusMalus;
	}

	public void setBonusMalus(double bonusMalus) {
		this.bonusMalus = bonusMalus;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
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

	@Override
	public String toString() {
		return "Salary [salaryId=" + salaryId + ", sUser=" + sUser + ", basicSalary=" + basicSalary + ", overSalary="
				+ overSalary + ", socialInsurance=" + socialInsurance + ", bonusMalus=" + bonusMalus + ", totalSalary="
				+ totalSalary + ", sYear=" + sYear + ", sMonth=" + sMonth + "]";
	}

	

}
