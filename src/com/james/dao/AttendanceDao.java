package com.james.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.james.entity.Attendance;

public interface AttendanceDao {
	
	int addAttendance(Attendance attendance);
	
	int updateAttendance(Attendance attendance);
	
	List<Attendance> queryAttByYearAndMonth(@Param(value = "aYear")int aYear,@Param(value = "aMonth")int aMonth);
	
	List<Attendance> queryAttByUserIdAndYearAndMonth(@Param(value = "userId")Integer userId, @Param(value = "aYear")int aYear,@Param(value = "aMonth")int aMonth);
	
	Attendance queryAttByUserIdAndDate(@Param(value = "userId")Integer userId,@Param(value = "aYear")int aYear,@Param(value = "aMonth")int aMonth,@Param(value = "aDay")int aDay);
	
	int queryAbsenceDaysByUserIdAndYearAndMonth(@Param(value = "userId")Integer userId,@Param(value = "aYear")int aYear,@Param(value = "aMonth")int aMonth);
}
