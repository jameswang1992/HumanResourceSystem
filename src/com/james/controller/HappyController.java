package com.james.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("happy")
@Controller
public class HappyController {
	
	@RequestMapping("inform")
	public String showNotification() {
		return "deptManager/showNotice";
	}
}
