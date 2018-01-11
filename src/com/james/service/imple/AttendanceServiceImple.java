package com.james.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.dao.AttendanceDao;
import com.james.entity.Attendance;
import com.james.service.AttendanceService;

@Service("attendService")
public class AttendanceServiceImple implements AttendanceService {
	
	@Autowired
	private AttendanceDao attendDao;
	
	public int addAttendance(Attendance attendance) {
		return attendDao.addAttendance(attendance);
	}


	public int updateAttendance(Attendance attendance) {
		return attendDao.updateAttendance(attendance);
	}

	public List<Attendance> queryAttByYearAndMonth(int aYear, int aMonth) {
		return attendDao.queryAttByYearAndMonth(aYear, aMonth);
	}

	public Attendance queryAttByUserIdAndDate(Integer userId, int aYear, int aMonth, int aDay) {
		return attendDao.queryAttByUserIdAndDate(userId, aYear, aMonth, aDay);
	}


	public int queryAbsenceDaysByUserIdAndYearAndMonth(Integer userId, int aYear, int aMonth) {
		return attendDao.queryAbsenceDaysByUserIdAndYearAndMonth(userId, aYear, aMonth);
	}


	public List<Attendance> queryAttByUserIdAndYearAndMonth(Integer userId, int aYear, int aMonth) {
		return attendDao.queryAttByUserIdAndYearAndMonth(userId, aYear, aMonth);
	}

}
