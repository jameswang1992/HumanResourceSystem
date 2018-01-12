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

import com.alibaba.fastjson.JSON;
import com.james.entity.Attendance;
import com.james.entity.Bonusmalus;
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
        currentTime.set(aYear, aMonth-1, aDay, 9, 0, 0);//设置上班时间9点
        Date normalTime = currentTime.getTime();
        String isLate= "";
        if(checkinTime.before(normalTime)) {
        	isLate="正常";
        }else {
        	isLate="迟到";
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
        currentTime.set(aYear, aMonth-1, aDay, 17, 0, 0);//设置下班时间17点
        Date normalTime = currentTime.getTime();
        Date checkoutTime = new Date();
        String isLeaveEarly= "";
        if(checkoutTime.before(normalTime)) {
        	isLeaveEarly="早退";
        }else {
        	isLeaveEarly="正常";
        }
        
        
        long gap = normalTime.getTime()-checkoutTime.getTime();
        int ominGap = (int) (gap/1000/60);
       
           
        String data = "0";
        Attendance attend = attendService.queryAttByUserIdAndDate(user.getUserId(), aYear, aMonth, aDay);
        if(attend != null) {
        	Date checkinTime = attend.getRaceStart();
        	 currentTime.set(aYear, aMonth-1, aDay, 9, 0, 0);
        	 Date officeTime = currentTime.getTime();
        	 long gap1 = checkinTime.getTime()-officeTime.getTime();
             int iminGap = (int) (gap1/1000/60);
        	 if(iminGap+ominGap >= 180 && iminGap > 0 && ominGap > 0) {
             	isLeaveEarly="旷工";
             	String isLate = "旷工";
             	attend.setIsLate(isLate);
             	Bonusmalus bm = new Bonusmalus(-1, user, -300, "旷工", new Date(), "惩罚");
             	bmService.insertBM(bm);
             }else if(iminGap > 0){
            	Bonusmalus bm = new Bonusmalus(-1, user, -100, "迟到", new Date(), "惩罚");
              	bmService.insertBM(bm);
             }else if(ominGap > 0) {
            	Bonusmalus bm = new Bonusmalus(-1, user, -100, "早退", new Date(), "惩罚");
               	bmService.insertBM(bm);
             }
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
	
	
	/**
	 * 忘了打卡
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("goCheck")
	public String goCheck(HttpSession session,Model model) {
		User user = (User) session.getAttribute("user");
		Calendar currentTime = Calendar.getInstance();
		int aYear = currentTime.get(Calendar.YEAR);   
        int aMonth = currentTime.get(Calendar.MONTH)+1; //第一个月从0开始，所以得到月份＋1  
        int aDay = currentTime.get(Calendar.DAY_OF_MONTH);
        Attendance attendance = attendService.queryAttByUserIdAndDate(user.getUserId(), aYear, aMonth, aDay);
        model.addAttribute("attendance", attendance);
		return "employee/emp";
	}
	
	/**
	 * 我的考勤
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("showAttendance")
	public String showAttendance(HttpSession session,Model model) {
		User user = (User) session.getAttribute("user");
		Calendar currentTime = Calendar.getInstance();
		int aYear = currentTime.get(Calendar.YEAR);   
        int aMonth = currentTime.get(Calendar.MONTH)+1;
        List<Attendance> attends = attendService.queryAttByUserIdAndYearAndMonth(user.getUserId(), aYear, aMonth);
        int absenceDays = attendService.queryAbsenceDaysByUserIdAndYearAndMonth(user.getUserId(), aYear, aMonth);
        model.addAttribute("attends", attends);
        model.addAttribute("aYear", aYear);
        model.addAttribute("aMonth", aMonth);
        model.addAttribute("absenceDays", absenceDays);
		return "employee/showAttendance";
	}
	
	
	/**
	 * 查看别的时间的考勤
	 * @param aYear
	 * @param aMonth
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("searchRecord")
	public String searchRecord(int aYear,int aMonth,HttpSession session,Model model) {
		System.out.println(aYear);
		System.out.println(aMonth);
		User user = (User) session.getAttribute("user");
		int absenceDays = 0;
		List<Attendance> attends = attendService.queryAttByUserIdAndYearAndMonth(user.getUserId(), aYear, aMonth);
		if(attends.size() == 0) {
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
		model.addAttribute("attends", attends);
		model.addAttribute("aYear", aYear);
        model.addAttribute("aMonth", aMonth);
		model.addAttribute("absenceDays", absenceDays);
		return "employee/showAttendance";
	}
	
	@RequestMapping("backup")
	public String backup(HttpSession session,Model model) {
		System.out.println("111");
		User user = (User) session.getAttribute("user");
		Calendar currentTime = Calendar.getInstance();
		int aYear = currentTime.get(Calendar.YEAR);   
        int aMonth = currentTime.get(Calendar.MONTH)+1; //第一个月从0开始，所以得到月份＋1  
        int aDay = currentTime.get(Calendar.DAY_OF_MONTH);
        Attendance attendance = attendService.queryAttByUserIdAndDate(user.getUserId(), aYear, aMonth, aDay);
        model.addAttribute("attendance", attendance);
		return "employee/emp";
	}
	
	@RequestMapping("updatePW")
	public String updatePW() {
		System.out.println("111");
		return "employee/updatePW";
	}
	
	
	@RequestMapping("updatePW1")
	public String updatePW1(String password,HttpSession session) {
		User user = (User) session.getAttribute("user");
		user.setPassword(password);
		int res = userService.modifyUser(user);
		return "employee/updatePW";
	}
}












































