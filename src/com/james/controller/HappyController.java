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
import com.james.entity.Bonusmalus;
import com.james.entity.Department;
import com.james.entity.Interview;
import com.james.entity.Position;
import com.james.entity.Recruitment;
import com.james.entity.Resume;
import com.james.entity.User;
import com.james.service.BonusmalusService;
import com.james.service.DepartmentService;
import com.james.service.InterviewService;
import com.james.service.PositionService;
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
	@Autowired
	private BonusmalusService bmService;
	@Autowired
	private DepartmentService deptService;
	@Autowired
	private PositionService posService;
	
	
	
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
	
	/**
	 * 显示具体信息
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("specificInfo")
	public String specificInfo(Integer userId,Model model) {
		Resume resume = resumeService.queryResumeByUserId(userId);
		User user = userService.queryUserByUserId(userId);
		model.addAttribute("resume", resume);
		model.addAttribute("user", user);
		return "manager/specificInfo";
	}
	
	/**
	 * 奖励
	 * @param bmReason
	 * @param bmSalary
	 * @param bmTime
	 * @param userId
	 * @return
	 */
	@RequestMapping("reward")
	@ResponseBody
	public String reward(String bmReason,double bmSalary,String bmTime,Integer userId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date bmTime1 = null;
		try {
			bmTime1 = sdf.parse(bmTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		User user = userService.queryUserByUserId(userId);
		Bonusmalus bm = new Bonusmalus(-1, user, bmSalary, bmReason, bmTime1, "奖励");
		String data = "0";
		int res = bmService.insertBM(bm);
		if(res == 1) {
			data = "1";
		}
		return data;
	}
	
	/**
	 * 调动部门职位
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("transfer")
	public String transfer(Integer userId,Model model) {
		User user = userService.queryUserByUserId(userId);
		List<Department> depts = deptService.queryAllDepts();
		List<Position> positions = posService.queryPositionsByDeptId(user.getuDepartment().getDeptId());
		model.addAttribute("user", user);
		model.addAttribute("depts", depts);
		model.addAttribute("positions", positions);
		return "manager/transfer";
	}
	
	/**
	 * 确认调动部门职位
	 * @param userId
	 * @param deptId
	 * @param positionId
	 * @return
	 */
	@RequestMapping("confirmTransfer")
	@ResponseBody
	public String confirmTransfer(Integer userId,Integer deptId,Integer positionId) {
		User user = userService.queryUserByUserId(userId);
		Department dept = deptService.queryDeptByDeptId(deptId);
		Position position = posService.queryPositionByPositionId(positionId);
		user.setuDepartment(dept);
		user.setuPosition(position);
		int res = userService.modifyUser(user);
		String data = "0";
		if(res == 1) {
			data = "1";
		}
		return data;
	}
	
	/**
	 * 修改部门
	 * @param deptName
	 * @param deptId
	 * @return
	 */
	@RequestMapping("modifyDept")
	@ResponseBody
	public String modifyDept(String deptName,Integer deptId) {
		String data = "0";
		/*if(deptName == null) {
			data = "2";
		}*/
		Department dept = deptService.queryDeptByDeptName(deptName);
		if(dept == null) {
			Department dept1 = deptService.queryDeptByDeptId(deptId);
			dept1.setDeptName(deptName);
			int res = deptService.updateDept(dept1);
			if(res == 1) {
				data = "1";
			}		
		}else {
			data = "3";
		}
		return data;		
	}
	
	/**
	 * 删除部门
	 * @param deptId
	 * @return
	 */
	@RequestMapping("deleteDept")
	@ResponseBody
	public String deleteDept(Integer deptId) {
		List<User> users = userService.queryUsersByDeptId(deptId);
		String data ="0";
		if(users.size() != 0) {
			data = "1";
		}else {
			int res = deptService.deleteDept(deptId);
			if(res == 1) {
				data = "2";
			}
		}
		return data;
	}
	
	/**
	 * 修改职位
	 * @param positionName
	 * @param positionId
	 * @return
	 */
	@RequestMapping("modifyPosition")
	@ResponseBody
	public String modifyPosition(String positionName,Integer positionId) {
		System.out.println("111");
		Position position = posService.queryPositionByPositionId(positionId);
		String data ="0";
		if(position.getPositionName().equals(positionName)) {
			data = "1";
		}else {
			position.setPositionName(positionName);
			int res = posService.updatePosition(position);
			if(res == 1) {
				data = "2";
			}
		}
		return data;
	}
	
	/**
	 * 删除职位
	 * @param positionId
	 * @return
	 */
	@RequestMapping("deletePosition")
	@ResponseBody
	public String deletePosition(Integer positionId) {
		List<User> users = userService.queryUsersByPositionId(positionId);
		String data ="0";
		if(users.size() != 0) {
			data = "1";
		}else {
			int res = posService.deletePosition(positionId);
			if(res == 1) {
				data = "2";
			}
		}
		return data;
	}
	
	@RequestMapping("back")
	public String back() {
		return "forward:/happy/showEmployees";
	}
}
















































