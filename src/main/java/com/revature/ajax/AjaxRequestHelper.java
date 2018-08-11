package com.revature.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.InfoController;
import com.revature.controller.RequestController;

public class AjaxRequestHelper {

	public static Object processRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) {
		case "/FrontServlet/grabInfo.ajax":
			return InfoController.grabInfo(request, response);
		case "/FrontServlet/grabRequests.ajax":
			return RequestController.grabRequests(request, response);
		case "/FrontServlet/grabAllRequests.ajax":
			return RequestController.grabAllRequests(request, response);
		case "/FrontServlet/grabEmployees.ajax":
			return InfoController.grabEmployees(request, response);
		case "/FrontServlet/update.ajax":
			return InfoController.updateStatus(request, response);
		default:
			return null;
		}
	}
}
