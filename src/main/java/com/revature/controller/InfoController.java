package com.revature.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.services.EmployeeService;
import com.revature.services.RequestService;

public class InfoController {
	
	public static Object grabInfo(HttpServletRequest req, HttpServletResponse resp) {
		Employee e = (Employee)req.getSession(false).getAttribute("loggedEmployee");
		return e;
	}
	
	public static Object grabEmployees(HttpServletRequest req, HttpServletResponse resp) {
		return EmployeeService.getAllEmployee();
	}
	
	public static Object updateStatus(HttpServletRequest req, HttpServletResponse res) {
		System.out.println(req.getParameter("status"));
		System.out.println(req.getParameter("r_id"));
		int status = Integer.parseInt(req.getParameter("status"));
		int id = Integer.parseInt(req.getParameter("r_id"));
		Request r = RequestService.getRequest(id);
		r.setResolved(status);
		RequestService.updateRequest(r);
		return r;
	}
	
	public static String updateInfo(HttpServletRequest req) {
		String first = req.getParameter("first");
		String last = req.getParameter("last");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		int id = ((Employee) req.getSession(false).getAttribute("loggedEmployee")).getE_id();
		int m = ((Employee) req.getSession(false).getAttribute("loggedEmployee")).getIsManager();
		LocalDate db = ((Employee) req.getSession(false).getAttribute("loggedEmployee")).getDateOfBirth();
		EmployeeService.updateEmployee(new Employee(id,email,pass,first,last,db,m));
		return "employee.html";
	}
}
