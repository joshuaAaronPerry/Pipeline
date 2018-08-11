package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {

	public static String processRequest(HttpServletRequest request) {
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) {
		case "/ERSProject/FrontServlet/login.do":
			return LoginController.login(request);
		case "/ERSProject/FrontServlet/logout.do":
			return LogoutController.logout(request);
		case "/ERSProject/FrontServlet/employee.do":
			return EmployeeController.employeePage(request);
		case "/ERSProject/FrontServlet/rr.do":
			return RequestController.createRequest(request);
		case "/ERSProject/FrontServlet/update.do":
			return InfoController.updateInfo(request);
		default: return "404.html";
		}
	}
}
