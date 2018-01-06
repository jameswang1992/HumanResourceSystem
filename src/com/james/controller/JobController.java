package com.james.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.james.entity.Department;
import com.james.entity.Position;
import com.james.entity.Recruitment;
import com.james.service.DepartmentService;
import com.james.service.PositionService;
import com.james.service.RecruitmentService;

@Controller
@RequestMapping("job")
public class JobController {
	
	@Autowired
	private RecruitmentService recmtService;
	@Autowired
	private DepartmentService deptService;
	@Autowired
	private PositionService posService;
	
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
	
	@RequestMapping("insertApp")
	@ResponseBody
	public String insertApp(Integer recruitId) {
		Recruitment recmt = recmtService.queryRecmtByRecmtId(recruitId);
		
	}
	
	@RequestMapping("back")
	public String back() {
		return "manager/admin";
	}
}




















