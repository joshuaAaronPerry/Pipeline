package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDao implements EmployeeDaoInterface {
	
public static EmployeeDao employeeDao;
	
	private EmployeeDao() {
		
	}
	
	public static EmployeeDao getDao() {
		if(employeeDao == null)
			employeeDao = new EmployeeDao();
		return employeeDao;
	}

	public Employee getEmployee(int eid) {
		try {
			Connection c = ConnectionUtil.getConnection();
			String sql = "select * from Employee where e_id=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Employee(rs.getInt("e_id"),
									rs.getString("email"),
									rs.getString("password"),
									rs.getString("firstName"),
									rs.getString("lastName"),
									rs.getDate("dateOfBirth").toLocalDate(),
									rs.getInt("isManager"));
			}
		} catch(SQLException e) {
			System.out.println("Could not get connection.");
			e.getMessage();
		}
		return null;
	}

	public Employee getEmployee(String email) {
		try {
			Connection c = ConnectionUtil.getConnection();
			String sql = "select * from employee where email=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Employee(rs.getInt("e_id"),
									rs.getString("email"),
									rs.getString("password"),
									rs.getString("firstName"),
									rs.getString("lastName"),
									rs.getDate("birth").toLocalDate(),
									rs.getInt("isManager"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Could not get connection.");
			e.getMessage();
		}
		return null;
	}

	public List<Employee> getAllEmployee() {
		try {
			List<Employee> employees = new ArrayList<>();
			Connection c = ConnectionUtil.getConnection();
			String sql = "select * from employee";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employees.add(new Employee(rs.getInt("e_id"),
									rs.getString("email"),
									rs.getString("password"),
									rs.getString("firstName"),
									rs.getString("lastName"),
									rs.getDate("birth").toLocalDate(),
									rs.getInt("isManager")));
			}
			return employees;
		} catch(SQLException e) {
			System.out.println("Could not get connection.");
			e.getMessage();
		}
		return null;
	}

	public boolean insertEmployee(Employee e) {
		try {
			Connection c = ConnectionUtil.getConnection();
			String sql = "call add_employee(?,?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, e.getEmail());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getFirstName());
			ps.setString(4, e.getLastName());
			ps.setObject(5, e.getDateOfBirth());
			ps.setInt(6, e.getIsManager());
			if(ps.executeUpdate() > 0) 
				return true;
		} catch(SQLException se) {
			System.out.println("Could not get connection.");
			se.getMessage();
		}
		return false;
	}

	public boolean deleteEmployee(int eid) {
		try {
			Connection c = ConnectionUtil.getConnection();
			String sql = "delete from employee where e_id=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, eid);
			if(ps.executeUpdate() > 0) 
				return true;
		} catch(SQLException e) {
			System.out.println("Could not get connection.");
			e.getMessage();
		}
		return false;
	}

	public boolean updateEmployee(Employee e) {
		try {
			Connection c = ConnectionUtil.getConnection();
			String sql = "update employee set e_id=?,email=?,password=?,firstName=?,lastName=?,birth=?,isManager=? where e_id=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, e.getE_id());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getFirstName());
			ps.setString(5, e.getLastName());
			java.sql.Date sqlDate = java.sql.Date.valueOf(e.getDateOfBirth());
			ps.setDate(6, sqlDate);
			ps.setInt(7, e.getIsManager());
			ps.setInt(8, e.getE_id());
			if(ps.executeUpdate() > 0)
				return true;
		} catch(SQLException se) {
			System.out.println("Could not get connection.");
			se.getMessage();
		}
		return false;
	}

}
