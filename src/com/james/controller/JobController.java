package com.james.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.james.entity.Application;
import com.james.entity.Department;
import com.james.entity.Interview;
import com.james.entity.Position;
import com.james.entity.Recruitment;
import com.james.entity.Resume;
import com.james.entity.User;
import com.james.service.ApplicationService;
import com.james.service.DepartmentService;
import com.james.service.InterviewService;
import com.james.service.PositionService;
import com.james.service.RecruitmentService;
import com.james.service.ResumeService;
import com.james.service.UserService;

@Controller
@RequestMapping("job")
public class JobController {
	
	@Autowired
	private RecruitmentService recmtService;
	@Autowired
	private DepartmentService deptService;
	@Autowired
	private PositionService posService;
	@Autowired
	private UserService userService;
	@Autowired
	private ApplicationService appService;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private InterviewService ivService;
	
	/**
	 * 游客查看招聘信息
	 * @param model
	 * @return
	 */
	@RequestMapping("recruitInfo")
	public String recruitInfo(Model model) {
		List<Recruitment> recmts = recmtService.queryAllRecmts();
		model.addAttribute("recmts", recmts);
		return "user/recruitInfo";
	}
	
	/**
	 * 跳转到发布招聘信息页面
	 * @param model
	 * @return
	 */
	@RequestMapping("recruit")
	public String recruit(Model model) {
		List<Department> depts = deptService.queryAllDepts();
		model.addAttribute("depts", depts);
		return "manager/recruit";
	}
	
	/**
	 * 发布招聘信息
	 * @param requirement
	 * @param treatment
	 * @param deptId
	 * @param positionId
	 * @return
	 */
	@RequestMapping("postRecmt")
	public String postRecmt(String requirement,String treatment,Integer deptId,Integer positionId) {
		Department dept = deptService.queryDeptByDeptId(deptId);
		Position position = posService.queryPositionByPositionId(positionId);
		Recruitment recmt = new Recruitment(-1, dept, position, requirement, treatment, 0);
		int res = recmtService.insertRecmt(recmt);
		return "manager/admin";
	}
	
	
	
	
	@RequestMapping("deptPosit")
	public String deptPosit(Model model) {
		List<Department> depts = deptService.queryAllDepts();
		model.addAttribute("depts", depts);
		return "manager/deptposit";
	}
	
	
	/**
	 * 添加部门
	 * @param deptName
	 * @return
	 */
	@RequestMapping("insertDept")
	@ResponseBody
	public String insertDept(String deptName) {
		String data = "0";
		if(deptName == null) {
			data = "2";
		}
		Department dept = deptService.queryDeptByDeptName(deptName);
		if(dept == null) {
			Department dept1 = new Department(-1, deptName, new Date());
			int res = deptService.insertDept(dept1);
			data = "1";
		}
		return data;
	}
	
	/**
	 * 添加职位
	 * @param positionName
	 * @param deptId
	 * @return
	 */
	@RequestMapping("insertPosition")
	@ResponseBody
	public String insertPosition(String positionName, Integer deptId) {
		Department dept = deptService.queryDeptByDeptId(deptId);
		List<Position> positions = posService.queryPositionsByDeptId(deptId);
		String data = "0";
		for (Position p : positions) {
			if(p.getPositionName().equals(positionName)) {
				data = "1";
			}
		}
		if("0".equals(data)) {
			Position position = new Position(-1, positionName, dept, new Date());
			int res = posService.insertPosition(position);
		}
		return data;
		
	}
	
	/**
	 * 添加应聘信息
	 * @param session
	 * @return
	 */
	@RequestMapping("insertApp")
	@ResponseBody
	public String insertApp(Integer recruitId,HttpSession session) {
		String data = "0";
		User user = (User) session.getAttribute("user");
		Resume resume = resumeService.queryResumeByUserId(user.getUserId());
		System.out.println(resume);
		if(resume == null) {
			data = "3";
		}else {
			Recruitment recmt = recmtService.queryRecmtByRecmtId(recruitId);
			if(resume.getrDepartment().getDeptName().equals(recmt.getrDepartment().getDeptName())
					&&resume.getrPosition().getPositionName().equals(recmt.getrPosition().getPositionName())) {
				Application app = new Application(-1, user, recmt, new Date(),"未查看");
				int res = appService.insertApp(app);
				if(res == 1) {
					data = "1";
				}
			}else {
				data = "2";
			}
		}
		return data;
	}
	
	/**
	 * 查看应聘信息
	 * @param model
	 * @return
	 */
	@RequestMapping("showApp")
	public String showApp(Model model) {
		List<Application> apps = appService.queryAllApplications();
		model.addAttribute("apps", apps);
		return "manager/application";
	}
	
	/**
	 * 查看简历详细信息
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("showResume")
	public String showResume(Integer userId,Model model) {
		Application app = appService.queryAppByUserId(userId);
		app.setStatus("已查看");
		int res = appService.updateAppStatus(app);
		Resume resume = resumeService.queryResumeByUserId(userId);
		model.addAttribute("resume", resume);
		model.addAttribute("userId", userId);
		return "manager/showResume";
	}
	
	/**
	 * 添加面试信息
	 * @param userId
	 * @param interTime
	 * @param interAddress
	 * @return
	 */
	@RequestMapping("insertIV")
	@ResponseBody
	public String insertIV(Integer userId,String interTime,String interAddress) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date interTime1 = null;
		try {
			interTime1 = sdf.parse(interTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String data = "0";
		Application app = appService.queryAppByUserId(userId);
		Interview iv = new Interview(-1, interTime1, interAddress, app, "未录用");
		int res = ivService.insertIV(iv);
		if(res == 1) {
			data = "1";
		}
		return data;
	}
	
	/**
	 * 避免重复面试
	 * @param userId
	 * @return
	 */
	@RequestMapping("checkIV")
	@ResponseBody
	public String checkIV(Integer userId) {
		Interview iv = ivService.queryIVByUserId(userId);
		String data = "0";
		if(iv == null) {
			data = "1";
		}
		return data;
	}
	
	
	@RequestMapping("training")
	public String training() {
		return "manager/training";
	}
	
	@RequestMapping("back")
	public String back() {
		return "manager/admin";
	}
	
	@RequestMapping("back1")
	public String back1() {
		return "forward:/job/showApp";
	}
}




















