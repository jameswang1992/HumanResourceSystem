package com.james.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.dao.DepartmentDao;
import com.james.entity.Department;
import com.james.service.DepartmentService;

@Service("deptService")
public class DepartmentServiceImple implements DepartmentService {
	
	@Autowired
	private DepartmentDao deptDao;
	
	public List<Department> queryAllDepts() {
		return deptDao.queryAllDepartments();
	}


	public Department queryDeptByDeptId(Integer deptId) {
		return deptDao.queryDepartmentByDeptId(deptId);
	}



	public int insertDept(Department dept) {
		return deptDao.addDepartment(dept);
	}


	public Department queryDeptByDeptName(String deptName) {
		return deptDao.queryDepartmentByDeptName(deptName);
	}


	public int updateDept(Department dept) {
		return deptDao.updateDepartment(dept);
	}


	public int deleteDept(Integer deptId) {
		return deptDao.deleteDepartment(deptId);
	}

}
