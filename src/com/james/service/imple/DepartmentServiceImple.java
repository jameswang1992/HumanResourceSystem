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

}
