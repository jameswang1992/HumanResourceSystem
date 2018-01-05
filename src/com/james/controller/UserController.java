package com.james.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.james.entity.Department;
import com.james.entity.User;
import com.james.service.DepartmentService;
import com.james.service.PositionService;
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
	
	@RequestMapping("readResume")
	public String readResume(Model model) {
		List<Department> depts = deptService.queryAllDepts();
		model.addAttribute("depts", depts);
		return "user/resume";
	}
	
	@RequestMapping("queryPositionsByDeptId")
	@ResponseBody
	public String queryPositionsByDeptId(Integer deptId) {
		
	}
	
}


























