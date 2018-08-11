package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil {

	
	private ConnectionUtil() {
		
	}
	
	public static Connection getConnection() {
		InputStream in = null;
		try {
			Properties prop = new Properties();
			in = new FileInputStream("C:\\my_git_repos\\1807-july-jta\\Josh_Perry_Code\\ERSProject\\ERSProject\\src\\main\\resources\\connection.properties");
			prop.load(in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = null;
			String endpoint = prop.getProperty("jdbc.url");			
			String username = prop.getProperty("jdbc.username");
			String password = prop.getProperty("jdbc.password");
			con = DriverManager.getConnection(endpoint, username, password);
			return con;

			
		} catch(Exception e) {
			e.getMessage();
		}
		finally {
			
			try {
				System.out.println(in);
				in.close();
				
			} catch(IOException e) {
				e.getMessage();
			}
		}
		return null;
	}
}
