package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Request;
import com.revature.util.ConnectionUtil;

public class RequestDao implements RequestDaoInterface {
	
public static RequestDao requestDao;
	
	private RequestDao() {
		
	}
	
	public static RequestDao getDao() {
		if(requestDao == null)
			requestDao = new RequestDao();
		return requestDao;
	}

	public Request getRequest(int rid) {
		try {
			Connection c = ConnectionUtil.getConnection();
			String sql = "select * from request where r_id=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, rid);
			LocalDate ld;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getDate("closeDate") != null)
					ld = rs.getDate("clodeDate").toLocalDate();
				else ld = null;
				return new Request(rs.getInt("r_id"),
								   rs.getInt("e_id"),
								   rs.getString("description"),
								   rs.getDouble("amount"),
								   rs.getDate("openDate").toLocalDate(),
								   ld,
								   rs.getInt("resolved"));
			}
		} catch(SQLException e) {
			System.out.println("Could not get connection.");
			e.getMessage();
		}
		return null;
	}

	public List<Request> getAllRequests(int eid) {
		try {
			List<Request> requests = new ArrayList<>();
			Connection c = ConnectionUtil.getConnection();
			String sql = "select * from request where e_id=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			LocalDate ld;
			while(rs.next()) {
				if(rs.getDate("closeDate") != null)
					ld = rs.getDate("closeDate").toLocalDate();
				else ld = null;
				requests.add(new Request(rs.getInt("r_id"),
								   		 rs.getInt("e_id"),
								   		 rs.getString("description"),
								   		 rs.getDouble("amount"),
								   		 rs.getDate("openDate").toLocalDate(),
								   		 ld,
								   		 rs.getInt("resolved")));
			}
			return requests;
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Could not get connection.");
		}
		return null;
	}

	public List<Request> getAllRequests() {
		try {
			List<Request> requestList = new ArrayList<>();
			Connection c = ConnectionUtil.getConnection();
			String sql = "select * from request";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			LocalDate ld;
			while(rs.next()) {
				if(rs.getDate("closeDate") != null)
					ld = rs.getDate("closeDate").toLocalDate();
				else ld = null;
				requestList.add(new Request(rs.getInt("r_id"),
											rs.getInt("e_id"),
											rs.getString("description"),
											rs.getDouble("amount"),
											rs.getDate("openDate").toLocalDate(),
											ld,
											rs.getInt("resolved")));
			}
			return requestList;
		} catch(SQLException e) {
			System.out.println("Could not get connection.");
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertRequest(Request r) {
		try {
			Connection c = ConnectionUtil.getConnection();
			String sql = "call add_request(?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, r.getE_id());
			ps.setString(2, r.getDescription());
			ps.setDouble(3, r.getAmount());
			java.sql.Date rDate = java.sql.Date.valueOf(r.getOpenDate());
			ps.setObject(4, rDate);
			if(ps.executeUpdate() > 0)
				return true;
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Could not get connection.");
		}
		return false;
	}

	public boolean deleteRequest(int rid) {
		try {
			Connection c = ConnectionUtil.getConnection();
			String sql = "delete from request where r_id=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, rid);
			if(ps.executeUpdate() > 0)
				return true;
		} catch(SQLException e) {
			System.out.println("Could not get connection.");
			e.getMessage();
		}
		return false;
	}

	public boolean updateRequest(Request r) {
		try {
			Connection c = ConnectionUtil.getConnection();
			String sql = "update request set r_id =?,e_id=?,description=?,amount=?,openDate=?,closeDate=?,resolved=? where r_id=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, r.getR_id());
			ps.setInt(2, r.getE_id());
			ps.setString(3, r.getDescription());
			ps.setDouble(4, r.getAmount());
			java.sql.Date openDate = java.sql.Date.valueOf(r.getOpenDate());
			java.sql.Date closeDate;
			if(r.getCloseDate() != null)
				closeDate = java.sql.Date.valueOf(r.getCloseDate());
			else closeDate = null;
			ps.setDate(5, openDate);
			ps.setDate(6, closeDate);
			ps.setInt(7, r.getIsResolved());
			ps.setInt(8, r.getR_id());
			if(ps.executeUpdate() > 0)
				return true;
		} catch(SQLException e) {
			System.out.println("Could not get connection.");
			e.getMessage();
		}
		return false;
	}

}
