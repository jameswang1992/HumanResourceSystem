package com.james.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.james.entity.Recruitment;
import com.james.service.RecruitmentService;

@Controller
@RequestMapping("job")
public class JobController {
	
	@Autowired
	private RecruitmentService recmtService;
	
	@RequestMapping("recruitInfo")
	public String recruitInfo(Model model) {
		List<Recruitment> recmts = recmtService.queryAllRecmts();
		model.addAttribute("recmts", recmts);
		return "user/recruitInfo";
	}
}




















