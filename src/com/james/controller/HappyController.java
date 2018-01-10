package com.james.controller;



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
import com.james.service.InterviewService;
import com.james.service.RecruitmentService;
import com.james.service.ResumeService;
import com.james.service.UserService;

@RequestMapping("happy")
@Controller
public class HappyController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private InterviewService ivService;
	@Autowired
	private RecruitmentService recmtService;
	@Autowired
	private ResumeService resumeService;
	
	
	
	@RequestMapping("inform")
	public String showNotification() {
		return "deptManager/showNotice";
	}
	
	/**
	 * 同意录用
	 * @param userId
	 * @param session
	 * @return
	 */
	@RequestMapping("agree")
	@ResponseBody
	public String agree(Integer userId,HttpSession session) {
		Interview iv = ivService.queryIVByUserId(userId);
		User user = iv.getiApp().getaUser();
		Recruitment recmt1 = iv.getiApp().getaRecmt();
		Recruitment recmt = recmtService.queryRecmtByRecmtId(recmt1.getRecruitId());
		Department dept = recmt.getrDepartment();
		Position position = recmt.getrPosition();

		user.setuDepartment(dept);
		user.setuPosition(position);
		user.setEntryTime(new Date());
		user.setUserType(2);//表示该游客成为了员工
		int res1 = userService.modifyUser(user);
		
		recmt.setExpired(1);//表示有人入职了
		int res2 = recmtService.updateRecmt(recmt);
		
		iv.setIsHire("已录用");
		int res = ivService.updateIV(iv);
		
		String data = "0";
		if(res == 1 && res1 == 1 && res2 == 1) {
			data = "1";
			List<Interview> ivs = (List<Interview>) session.getAttribute("ivs");
			for(int i = 0; i < ivs.size(); i++) {
				if(ivs.get(i).getInterviewId() == iv.getInterviewId()) {
					ivs.remove(i);
				}
			}
		}
		return data;
		
	}
	
	/**
	 * 拒绝录用
	 * @param userId
	 * @return
	 */
	@RequestMapping("disagree")
	@ResponseBody
	public String disagree(Integer userId,HttpSession session) {
		Interview iv = ivService.queryIVByUserId(userId);
		iv.setIsHire("被拒绝");
		int res = ivService.updateIV(iv);
		String data = "0";
		if(res == 1) {
			data = "1";
			List<Interview> ivs = (List<Interview>) session.getAttribute("ivs");
			for(int i = 0; i < ivs.size(); i++) {
				if(ivs.get(i).getInterviewId() == iv.getInterviewId()) {
					ivs.remove(i);
				}
			}
		}
		return data;
	}
	
	/**
	 * 显示员工
	 * @param model
	 * @return
	 */
	@RequestMapping("showEmployees")
	public String showEmployees(Model model) {
		List<User> emps = userService.queryUsersByUserType();
		model.addAttribute("emps", emps);
		return "manager/showEmployees";
	}
	
	@RequestMapping("specificInfo")
	public String specificInfo(Integer userId,Model model) {
		Resume resume = resumeService.queryResumeByUserId(userId);
		model.addAttribute("resume", resume);
		return "manager/specificInfo";
	}
	
}
















































