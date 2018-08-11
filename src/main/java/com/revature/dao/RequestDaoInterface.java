package com.revature.dao;

import java.util.List;

import com.revature.models.Request;

public interface RequestDaoInterface {

	public Request getRequest(int rid);
	public List<Request> getAllRequests(int eid);
	public List<Request> getAllRequests();
	public boolean insertRequest(Request r);
	public boolean deleteRequest(int rid);
	public boolean updateRequest(Request r);
}
