package com.james.service;

import java.util.List;

import com.james.entity.Department;

public interface DepartmentService {
	
	List<Department> queryAllDepts();
	
	Department queryDeptByDeptId(Integer deptId);
	
	int insertDept(Department dept);
	
	int updateDept(Department dept);
	
	int deleteDept(Integer deptId);
	
	Department queryDeptByDeptName(String deptName);
}
