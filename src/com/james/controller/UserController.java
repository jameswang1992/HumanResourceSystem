package com.james.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.james.entity.Department;
import com.james.entity.Position;
import com.james.entity.Resume;
import com.james.entity.User;
import com.james.service.DepartmentService;
import com.james.service.PositionService;
import com.james.service.ResumeService;
import com.james.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private DepartmentService deptService;
	@Autowired
	private PositionService posService;
	@Autowired
	private ResumeService resumeService;
	
	@RequestMapping("register")
	public String register(String userName,String password) {
		int res = userService.register(userName, password);
		System.out.println(res);
		if(res == 1) {
			return "forward:../login.jsp";
		}
		
		return "user/fail";
	}
	
	@RequestMapping("login")
	public String login(String userName,String password,HttpSession session) {
		User user = userService.login(userName, password);
		session.setAttribute("user", user);
		if(user.getUserType() == 1) {
			return "user/tourist";
		}else if(user.getUserType() == 0){
			return "manager/admin";
		}
		return "user/tourist";
	}
	
	@RequestMapping("queryUserByUserName")
	@ResponseBody
	public String queryUserByUserName(String userName) {
		User user = userService.queryUserByUserName(userName);
		String data = "0";
		if(user != null) {
			data = "1";
		}
		return data;
	}
	
	/**
	 * 如果第二次查看简历，回显
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("readResume")
	public String readResume(Model model,HttpSession session) {
		User user = (User) session.getAttribute("user");
		Resume oldResume = resumeService.queryResumeByUserId(user.getUserId());
		if(oldResume != null) {
			Department dept = oldResume.getrDepartment();
			List<Position> positions = posService.queryPositionsByDeptId(dept.getDeptId());
			model.addAttribute("oldResume", oldResume);
			model.addAttribute("positions", positions);
		}
		List<Department> depts = deptService.queryAllDepts();
		model.addAttribute("depts", depts);
		return "user/resume";
	}
	
	/**
	 * ajax，根据部门ID查找这个部门有哪些职位
	 * @param deptId
	 * @param response
	 * @return
	 */
	@RequestMapping(value="queryPositionsByDeptId",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryPositionsByDeptId(Integer deptId,HttpServletResponse response) {
		List<Position> positions = posService.queryPositionsByDeptId(deptId);
		String data = JSON.toJSONString(positions);
		return data;
	}
	
	/**
	 * 添加简历信息,完成二级联动
	 * @param model
	 * @param resume
	 * @param deptId
	 * @param positionId
	 * @param session
	 * @return
	 */
	@RequestMapping("insertResume")
	public String insertResume(Model model,Resume resume,Integer deptId,Integer positionId,HttpSession session) {
		User user = (User) session.getAttribute("user");
		Resume oldResume = resumeService.queryResumeByUserId(user.getUserId());
		if(oldResume != null) {
			Department dept = deptService.queryDeptByDeptId(deptId);
			Position position = posService.queryPositionByPositionId(positionId);
			oldResume.setrDepartment(dept);
			oldResume.setrPosition(position);
			oldResume.setAcademic(resume.getAcademic());
			oldResume.setAge(resume.getAge());
			oldResume.setContact(resume.getContact());
			oldResume.setEmail(resume.getEmail());
			oldResume.setExjob(resume.getExjob());
			oldResume.setExpectedSalary(resume.getExpectedSalary());
			oldResume.setExperience(resume.getExperience());
			oldResume.setGender(resume.getGender());
			oldResume.setHobby(resume.getHobby());
			oldResume.setRealName(resume.getRealName());
			oldResume.setPolitical(resume.getPolitical());
			int res1 = resumeService.modifyResume(oldResume);
			return "user/tourist";
		}
		Department dept = deptService.queryDeptByDeptId(deptId);
		Position position = posService.queryPositionByPositionId(positionId);
		resume.setrDepartment(dept);
		resume.setrPosition(position);
		resume.setrUser(user);
		resume.setStatus("未查看");
		int res = resumeService.insertResume(resume);
		return "user/tourist";
	}
	
	/**
	 * 修改密码
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("modifyPW")
	public String modifyPW(String password,HttpSession session) {
		User user = (User) session.getAttribute("user");
		user.setPassword(password);
		int res = userService.modifyUser(user);
		return "user/tourist";
	}
	
	@RequestMapping("modify")
	public String modify(Model model,HttpSession session) {
		User user = (User) session.getAttribute("user");
		String password = user.getPassword();
		model.addAttribute("password", password);
		return "user/modifyPW";
	}
	
	
	@RequestMapping("back")
	public String back() {
		return "user/tourist";
	}
	
}


























