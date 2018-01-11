package com.james.entity;

import java.util.Date;

/**
 * 考勤类
 * 
 * @author jameswang
 *
 */
public class Attendance {

	private Integer attendId;
	private User aUser;
	private Date raceStart;// 上班时间
	private Date gameOver;// 下班时间
	private int aYear;
	private int aMonth;
	private int aDay;
	private String isLate;// 是否迟到
	private String isLeaveEarly;// 是否早退
	private int absenceDays;// 缺勤天数

	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attendance(Integer attendId, User aUser, Date raceStart, Date gameOver, int aYear, int aMonth, int aDay,
			String isLate, String isLeaveEarly, int absenceDays) {
		super();
		this.attendId = attendId;
		this.aUser = aUser;
		this.raceStart = raceStart;
		this.gameOver = gameOver;
		this.aYear = aYear;
		this.aMonth = aMonth;
		this.aDay = aDay;
		this.isLate = isLate;
		this.isLeaveEarly = isLeaveEarly;
		this.absenceDays = absenceDays;
	}

	public Integer getAttendId() {
		return attendId;
	}

	public void setAttendId(Integer attendId) {
		this.attendId = attendId;
	}

	public User getaUser() {
		return aUser;
	}

	public void setaUser(User aUser) {
		this.aUser = aUser;
	}

	public Date getRaceStart() {
		return raceStart;
	}

	public void setRaceStart(Date raceStart) {
		this.raceStart = raceStart;
	}

	public Date getGameOver() {
		return gameOver;
	}

	public void setGameOver(Date gameOver) {
		this.gameOver = gameOver;
	}

	public int getaYear() {
		return aYear;
	}

	public void setaYear(int aYear) {
		this.aYear = aYear;
	}

	public int getaMonth() {
		return aMonth;
	}

	public void setaMonth(int aMonth) {
		this.aMonth = aMonth;
	}

	public int getaDay() {
		return aDay;
	}

	public void setaDay(int aDay) {
		this.aDay = aDay;
	}

	public String getIsLate() {
		return isLate;
	}

	public void setIsLate(String isLate) {
		this.isLate = isLate;
	}

	public String getIsLeaveEarly() {
		return isLeaveEarly;
	}

	public void setIsLeaveEarly(String isLeaveEarly) {
		this.isLeaveEarly = isLeaveEarly;
	}

	public int getAbsenceDays() {
		return absenceDays;
	}

	public void setAbsenceDays(int absenceDays) {
		this.absenceDays = absenceDays;
	}

	@Override
	public String toString() {
		return "Attendance [attendId=" + attendId + ", aUser=" + aUser + ", raceStart=" + raceStart + ", gameOver="
				+ gameOver + ", aYear=" + aYear + ", aMonth=" + aMonth + ", aDay=" + aDay + ", isLate=" + isLate
				+ ", isLeaveEarly=" + isLeaveEarly + ", absenceDays=" + absenceDays + "]";
	}

}
