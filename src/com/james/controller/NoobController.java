package com.james.controller;


import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.james.entity.Bonusmalus;
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
@RequestMapping("noob")
public class NoobController {
	
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
	 * 绩效
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("rewards")
	public String giveRewards(HttpSession session,Model model) {
		User user = (User) session.getAttribute("user");
		List<User> emps = userService.queryUsersByDeptId(user.getuDepartment().getDeptId());
		model.addAttribute("emps", emps);
		return "deptManager/deptEmps";
	}
	
	
	
	/**
	 * 查看个人奖惩
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("myBM")
	public String showMyBM(HttpSession session,Model model) {
		User user = (User) session.getAttribute("user");
		Calendar currentTime = Calendar.getInstance();
		int bYear = currentTime.get(Calendar.YEAR);   
        int bMonth = currentTime.get(Calendar.MONTH)+1;
        List<Bonusmalus> bms = bmService.queryBMsByUserIdAndDate(user.getUserId(), bYear, bMonth);
		session.setAttribute("bms", bms);
		model.addAttribute("bYear", bYear);
		model.addAttribute("bMonth", bMonth);
		return "employee/showMyBM";
	}
	
	/**
	 * 员工搜索自己奖惩
	 * @param session
	 * @param bYear
	 * @param bMonth
	 * @param model
	 * @return
	 */
	@RequestMapping("searchbmRecord")
	public String searchbmRecord(HttpSession session,int bYear,int bMonth,Model model) {
		User user = (User) session.getAttribute("user");
		List<Bonusmalus> bms = bmService.queryBMsByUserIdAndDate(user.getUserId(), bYear, bMonth);
		session.setAttribute("bms", bms);
		model.addAttribute("bYear", bYear);
		model.addAttribute("bMonth", bMonth);
		return "employee/showMyBM";
	}
	
	/**
	 * 管理员查看当月所有记录
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("showBM")
	public String showBM(HttpSession session,Model model) {
		Calendar currentTime = Calendar.getInstance();
		int bYear = currentTime.get(Calendar.YEAR);   
        int bMonth = currentTime.get(Calendar.MONTH)+1;
        List<Bonusmalus> bms = bmService.queryBMsByDate(bYear, bMonth);
        session.setAttribute("bms", bms);
        model.addAttribute("bYear", bYear);
        model.addAttribute("bMonth", bMonth);
        return "manager/showAllBMs";
	}
	
	/**
	 * 管理员查看别月记录
	 * @param session
	 * @param bYear
	 * @param bMonth
	 * @param model
	 * @return
	 */
	@RequestMapping("searchAllRecord")
	public String searchAllRecord(HttpSession session,int bYear,int bMonth,Model model) {
		List<Bonusmalus> bms = bmService.queryBMsByDate(bYear, bMonth);
		session.setAttribute("bms", bms);
		model.addAttribute("bYear", bYear);
		model.addAttribute("bMonth", bMonth);
		return "manager/showAllBMs";
		
	}
}












































