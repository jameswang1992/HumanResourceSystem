package com.james.dao;

import java.util.List;

import com.james.entity.Department;

public interface DepartmentDao {
	
	int addDepartment(Department dept);
	
	int deleteDepartment(Integer deptId);
	
	int updateDepartment(Department dept);
	
	List<Department> queryAllDepartments();
	
	Department queryDepartmentByDeptId(Integer deptId);
	
	Department queryDepartmentByDeptName(String deptName);
	
}
