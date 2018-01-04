package com.james.entity;

/**
 * ������
 * 
 * @author jameswang
 *
 */
public class Resume {
	private Integer resumeId;// ����ID
	private User rUser;
	private String realName;// ��ʵ����
	private int age;
	private long contact;// ��ϵ��ʽ
	private String gender;
	private String academic;// ѧ��
	private String email;
	private String political;// ������ò
	private int experience;// ��������
	private String hobby;
	private String exjob;// �Ϸݹ���
	private String expectedSalary;// ��������
	private Department rDepartment;// ӦƸ����
	private Position rPosition;// ӦƸְλ
	private String status;// δ�鿴���Ѳ鿴

	public Resume() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resume(Integer resumeId, User rUser, String realName, int age, long contact, String gender, String academic,
			String email, String political, int experience, String hobby, String exjob, String expectedSalary,
			Department rDepartment, Position rPosition, String status) {
		super();
		this.resumeId = resumeId;
		this.rUser = rUser;
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
		this.status = status;
	}

	public Integer getResumeId() {
		return resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	public User getrUser() {
		return rUser;
	}

	public void setrUser(User rUser) {
		this.rUser = rUser;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Resume [resumeId=" + resumeId + ", rUser=" + rUser + ", realName=" + realName + ", age=" + age
				+ ", contact=" + contact + ", gender=" + gender + ", academic=" + academic + ", email=" + email
				+ ", political=" + political + ", experience=" + experience + ", hobby=" + hobby + ", exjob=" + exjob
				+ ", expectedSalary=" + expectedSalary + ", rDepartment=" + rDepartment + ", rPosition=" + rPosition
				+ ", status=" + status + "]";
	}

}
