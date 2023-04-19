package com.yedam.common;

import java.util.List;

import com.yedam.domain.Employee;

public interface NoticeMapper {
	public Employee getEmp(int empId);
	public List<Employee> empList();
	//delete insert update 반환되는 값이 int임. 건수를 보내기 때문
	public int delEmp(int empId);
	public int addEmp(Employee emp);
}
