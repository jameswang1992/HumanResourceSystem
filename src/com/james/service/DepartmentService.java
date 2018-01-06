package com.james.service;

import java.util.List;

import com.james.entity.Department;

public interface DepartmentService {
	
	List<Department> queryAllDepts();
	
	Department queryDeptByDeptId(Integer deptId);
	
	int insertDept(Department dept);
	
	Department queryDeptByDeptName(String deptName);
}
