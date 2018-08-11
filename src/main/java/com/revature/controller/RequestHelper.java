package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {

	public static String processRequest(HttpServletRequest request) {
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) {
		case "/FrontServlet/login.do":
			return LoginController.login(request);
		case "/FrontServlet/logout.do":
			return LogoutController.logout(request);
		case "/FrontServlet/employee.do":
			return EmployeeController.employeePage(request);
		case "/FrontServlet/rr.do":
			return RequestController.createRequest(request);
		case "/FrontServlet/update.do":
			return InfoController.updateInfo(request);
		default: return "404.html";
		}
	}
}
