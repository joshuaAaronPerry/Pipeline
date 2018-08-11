package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ajax.AjaxRequestHelper;
import com.revature.models.Employee;

public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().endsWith("ajax")) {
			response.setContentType("application/json");
			System.out.println(AjaxRequestHelper.processRequest(request, response));
			response.getWriter().write(
						new ObjectMapper().writeValueAsString(AjaxRequestHelper.processRequest(request, response)));
		}
		else {
			response.setContentType("text/html");
			request.getRequestDispatcher(RequestHelper.processRequest(request)).forward(request, response);
		}
		
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().endsWith("ajax")) {
			response.setContentType("application/json");
			response.getWriter().write(
						new ObjectMapper().writeValueAsString(AjaxRequestHelper.processRequest(request, response)));
			System.out.println(AjaxRequestHelper.processRequest(request, response));
		}
		else {
			response.setContentType("text/html");
			request.getRequestDispatcher(RequestHelper.processRequest(request)).forward(request, response);
		}
	}

}
