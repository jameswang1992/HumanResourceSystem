package com.james.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.james.entity.Salary;

public interface SalaryDao {
	
	int addSalary(Salary salary);
	
	List<Salary> querySalariesByDate(@Param(value = "sYear")int sYear, @Param(value = "sMonth")int sMonth);//根据年份和月份查工资表
	
	Salary querySalaryByUserId(Integer userId);
}
