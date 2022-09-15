package com.contact.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.contact.model.User;

public class UserDao {

	private Connection con;
	public UserDao() {
		con = DbConnection.getConnection();
	}
	
	public boolean login(String username,String password) {
		String q="select * from user where username=? and password=?";
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet result =ps.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void register(User user) {
		String q="insert into user value(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, user.getId());
			ps.setString(2,user.getUsername());
			ps.setString(3, user.getPassword());
			int n = ps.executeUpdate();
			System.out.println(n+" user added");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
