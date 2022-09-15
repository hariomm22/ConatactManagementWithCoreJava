package com.contact.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static Connection con=null;
	private static String username = "root";
	private static String password = "";
	private static String url = "jdbc:mysql://127.0.0.1:3306/contact_management_with_core_java";
	
	public DbConnection() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() {
		if(con==null) {
		try 
		{
			Class.forName(driver);
			
			con = DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
		return con;
	}

}
