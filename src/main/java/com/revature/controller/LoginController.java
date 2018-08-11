package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class LoginController {

	public static String login(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return "login.html";
		}
		Employee loggEmp = EmployeeService.getEmployee(req.getParameter("email"));
		System.out.println(loggEmp);
		if(loggEmp != null && loggEmp.getPassword().equals(req.getParameter("password"))) {
			req.getSession().setAttribute("loggedEmployee", loggEmp);
			if(loggEmp.getIsManager() == 0)
				return "employee.html";
			else return "manager.html";
		}
		else {
			return "login.html";
		}
	}
}
