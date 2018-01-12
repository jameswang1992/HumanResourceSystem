package com.james.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.james.entity.Salary;

public interface SalaryDao {
	
	int addSalary(Salary salary);
	
	int updateSalary(Salary salary);
	
	List<Salary> querySalariesByDate(@Param(value = "sYear")int sYear, @Param(value = "sMonth")int sMonth);//������ݺ��·ݲ鹤�ʱ�
	
	List<Salary> querySalaryByUserId(Integer userId);
	
	Salary querySalaryByUserIdAndDate(@Param(value = "userId")Integer userId,@Param(value = "sYear")int sYear, @Param(value = "sMonth")int sMonth);
	
	
}
