package com.james.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.james.entity.Attendance;
import com.james.entity.Resume;
import com.james.entity.User;
import com.james.service.AttendanceService;
import com.james.service.BonusmalusService;
import com.james.service.DepartmentService;
import com.james.service.InterviewService;
import com.james.service.PositionService;
import com.james.service.RecruitmentService;
import com.james.service.ResumeService;
import com.james.service.UserService;

@Controller
@RequestMapping("cry")
public class CryController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private InterviewService ivService;
	@Autowired
	private RecruitmentService recmtService;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private BonusmalusService bmService;
	@Autowired
	private DepartmentService deptService;
	@Autowired
	private PositionService posService;
	@Autowired
	private AttendanceService attendService;
	
	/**
	 * 个人信息
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("personalInfo")
	public String personalInfo(HttpSession session,Model model) {
		User user = (User) session.getAttribute("user");
		Resume resume = resumeService.queryResumeByUserId(user.getUserId());
		model.addAttribute("resume", resume);
		return "employee/personalInfo";
	}
	
	/**
	 * 修改个人信息
	 * @param age
	 * @param contact
	 * @param email
	 * @param hobby
	 * @param session
	 * @return
	 */
	@RequestMapping("modifyResume")
	@ResponseBody
	public String modifyResume(int age,long contact,String email,String hobby,HttpSession session) {
		User user = (User) session.getAttribute("user");
		Resume resume = resumeService.queryResumeByUserId(user.getUserId());
		resume.setAge(age);
		resume.setContact(contact);
		resume.setEmail(email);
		resume.setHobby(hobby);
		int res = resumeService.modifyResume(resume);
		String data = "0";
		if(res == 1) {
			data = "1";
		}
		return data;
	}
	
	
	/**
	 * 判断迟到
	 * @return
	 */
	@RequestMapping("checkin")
	@ResponseBody
	public String checkin(HttpSession session) {
		Date checkinTime  = new Date();
		Calendar currentTime = Calendar.getInstance();
		int aYear = currentTime.get(Calendar.YEAR);   
        int aMonth = currentTime.get(Calendar.MONTH)+1; //第一个月从0开始，所以得到月份＋1  
        int aDay = currentTime.get(Calendar.DAY_OF_MONTH);
        currentTime.set(aYear, aMonth, aDay, 9, 0, 0);//设置上班时间9点
        Date normalTime = currentTime.getTime();
        String isLate= "";
        if(checkinTime.before(normalTime)) {
        	isLate="迟到";
        }else {
        	isLate="正常";
        }
        User user = (User) session.getAttribute("user");
        List<Attendance> atts = attendService.queryAttByUserIdAndYearAndMonth(user.getUserId(), aYear, aMonth);
        int absenceDays = 0;
        if(atts.size() == 0) {
            switch (aMonth) {
    		case 1:case 3:case 5:case 7:case 8:case 10:case 12:
    			absenceDays = 31;		
    			break;
    		case 4:case 6:case 9:case 11:
    			absenceDays = 30;
    			break;
    		case 2:
    			if((aYear%4==0 && aYear%100!=0)|| aYear%400==0){
    				absenceDays = 29;
    			}else {
    				absenceDays = 28;
    			}
    		default:
    			break;
    		}
        }else {
        	absenceDays = attendService.queryAbsenceDaysByUserIdAndYearAndMonth(user.getUserId(), aYear, aMonth);
        }
        Attendance attendance = new Attendance(-1, user, checkinTime, null, aYear, aMonth, aDay, isLate, null, absenceDays-1);
        int res = attendService.addAttendance(attendance);
        String data = "0";
        if(res == 1) {
        	data = "1";
        }
        
		return data;
	}
	
	/**
	 * 下班打卡
	 * @param session
	 * @return
	 */
	@RequestMapping("checkout")
	@ResponseBody
	public String checkout(HttpSession session) {
		User user = (User) session.getAttribute("user");
		Calendar currentTime = Calendar.getInstance();
		int aYear = currentTime.get(Calendar.YEAR);   
        int aMonth = currentTime.get(Calendar.MONTH)+1; //第一个月从0开始，所以得到月份＋1  
        int aDay = currentTime.get(Calendar.DAY_OF_MONTH);
        currentTime.set(aYear, aMonth, aDay, 17, 0, 0);//设置下班时间17点
        Date normalTime = currentTime.getTime();
        Date checkoutTime = new Date();
        String isLeaveEarly= "";
        if(checkoutTime.before(normalTime)) {
        	isLeaveEarly="早退";
        }else {
        	isLeaveEarly="正常";
        }
        
        String data = "0";
        Attendance attend = attendService.queryAttByUserIdAndDate(user.getUserId(), aYear, aMonth, aDay);
        if(attend != null) {
        	attend.setGameOver(checkoutTime);
        	attend.setIsLeaveEarly(isLeaveEarly);
        	int res = attendService.updateAttendance(attend);
        	if(res == 1) {
        		data = "1";
        	}
        }else {
        	data = "2";
        }
        return data;
	}
	
	
	
	
	
	
	
	
	@RequestMapping("back")
	public String back() {
		return "employee/emp";
	}
}












































