package com.revature.services;

import java.util.List;

import com.revature.dao.RequestDao;
import com.revature.models.Request;

public class RequestService {

	public static RequestService requestService;
	
	private RequestService() {
		
	}
	
	public RequestService getRequestService() {
		if(requestService == null)
			requestService = new RequestService();
		return requestService;
	}
	
	public static Request getRequest(int rid) {
		return RequestDao.getDao().getRequest(rid);
	}
	
	public static List<Request> getAllRequests() {
		return RequestDao.getDao().getAllRequests();
	}
	
	public static List<Request> getAllRequests(int eid) {
		return RequestDao.getDao().getAllRequests(eid);
	}
	
	public static boolean insertRequest(Request r) {
		return RequestDao.getDao().insertRequest(r);
	}
	
	public static boolean deleteRequest(int rid) {
		return RequestDao.getDao().deleteRequest(rid);
	}
	
	public static boolean updateRequest(Request r) {
		return RequestDao.getDao().updateRequest(r);
	}
}
