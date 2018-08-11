package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class LogoutController {

	public static String logout(HttpServletRequest req) {
		if(req.getSession(false) != null)
			req.getSession(false).invalidate();
		return "login.html";
	}
}
