package com.james.service;

import java.util.List;

import com.james.entity.Attendance;

public interface AttendanceService {
	
	int addAttendance(Attendance attendance);
	
	int updateAttendance(Attendance attendance);
	
	List<Attendance> queryAttByYearAndMonth(int aYear,int aMonth);
	
	Attendance queryAttByUserIdAndDate(Integer userId,int aYear,int aMonth,int aDay);
	
	int queryAbsenceDaysByUserIdAndYearAndMonth(Integer userId,int aYear,int aMonth);
	
	List<Attendance> queryAttByUserIdAndYearAndMonth(Integer userId, int aYear,int aMonth);
}
