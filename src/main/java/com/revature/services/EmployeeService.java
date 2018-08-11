package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;

public class EmployeeService {

	private static EmployeeService employeeService;
	
	private EmployeeService() {
		
	}
	
	public static EmployeeService getEmployeeService() {
		if(employeeService == null)
			employeeService = new EmployeeService();
		return employeeService;
	}
	
	public static Employee getEmployee(int eid) {
		return EmployeeDao.getDao().getEmployee(eid);
	}
	
	public static Employee getEmployee(String email) {
		return EmployeeDao.getDao().getEmployee(email);
	}
	
	public static List<Employee> getAllEmployee() {
		return EmployeeDao.getDao().getAllEmployee();
	}
	
	public static boolean insertEmployee(Employee e) {
		return EmployeeDao.getDao().insertEmployee(e);
	}
	
	public static boolean deleteEmployee(int eid) {
		return EmployeeDao.getDao().deleteEmployee(eid);
	}
	
	public static boolean updateEmployee(Employee e) {
		return EmployeeDao.getDao().updateEmployee(e);
	}
}
