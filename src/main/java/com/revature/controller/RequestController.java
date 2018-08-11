package com.revature.controller;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.services.RequestService;

public class RequestController {

	public static String createRequest(HttpServletRequest req) {
		System.out.println(req.getSession(false));
		//System.out.println();
		Employee emp = (Employee) req.getSession(false).getAttribute("loggedEmployee");
		int id = emp.getE_id();
		try {
			double amount = Double.parseDouble(req.getParameter("amount"));
			String descr = req.getParameter("description");
			LocalDate today = LocalDate.now();
			Request r = new Request(0,id,descr,amount,today,null,0);
			RequestService.insertRequest(r);
		} catch(NumberFormatException e) {
			e.getMessage();
		}
		return "employee.html";
	}
	
	public static Object grabRequests(HttpServletRequest req, HttpServletResponse resp) {
		int id = ((Employee) req.getSession(false).getAttribute("loggedEmployee")).getE_id();
		System.out.println(id);
		System.out.println(RequestService.getAllRequests(id));
		return RequestService.getAllRequests(id);
	}
	
	public static Object grabAllRequests(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("lll");
		return RequestService.getAllRequests();
	}
}
