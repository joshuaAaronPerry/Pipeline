package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDaoInterface {

	public Employee getEmployee(int eid);
	public Employee getEmployee(String email);
	public List<Employee> getAllEmployee();
	public boolean insertEmployee(Employee e);
	public boolean deleteEmployee(int eid);
	public boolean updateEmployee(Employee e);
}
