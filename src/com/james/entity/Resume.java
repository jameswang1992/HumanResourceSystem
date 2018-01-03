package com.james.entity;

public class Resume {
	private Integer resumeId;// 简历ID
	private User user;
	private String realName;// 真实姓名
	private int age;
	private long contact;// 联系方式
	private String gender;
	private String academic;// 学历
	private String email;
	private String political;// 政治面貌
	private int experience;// 工作经验
	private String hobby;
	private String exjob;// 上份工作
	private String expectedSalary;// 期望工资
	private Department rDepartment;// 应聘部门
	private Position rPosition;// 应聘职位

	public Resume() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resume(Integer resumeId, User user, String realName, int age, long contact, String gender, String academic,
			String email, String political, int experience, String hobby, String exjob, String expectedSalary,
			Department rDepartment, Position rPosition) {
		super();
		this.resumeId = resumeId;
		this.user = user;
		this.realName = realName;
		this.age = age;
		this.contact = contact;
		this.gender = gender;
		this.academic = academic;
		this.email = email;
		this.political = political;
		this.experience = experience;
		this.hobby = hobby;
		this.exjob = exjob;
		this.expectedSalary = expectedSalary;
		this.rDepartment = rDepartment;
		this.rPosition = rPosition;
	}

	public Integer getResumeId() {
		return resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAcademic() {
		return academic;
	}

	public void setAcademic(String academic) {
		this.academic = academic;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPolitical() {
		return political;
	}

	public void setPolitical(String political) {
		this.political = political;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getExjob() {
		return exjob;
	}

	public void setExjob(String exjob) {
		this.exjob = exjob;
	}

	public String getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(String expectedSalary) {
		this.expectedSalary = expectedSalary;
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

	@Override
	public String toString() {
		return "Resume [resumeId=" + resumeId + ", user=" + user.getUserName() + ", realName=" + realName + ", age=" + age
				+ ", contact=" + contact + ", gender=" + gender + ", academic=" + academic + ", email=" + email
				+ ", political=" + political + ", experience=" + experience + ", hobby=" + hobby + ", exjob=" + exjob
				+ ", expectedSalary=" + expectedSalary + ", rDepartment=" + rDepartment.getDeptName() + ", rPosition=" + rPosition.getPositionName()
				+ "]";
	}

}
