package com.contact.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.contact.model.Contact;

public class ContactDao {

	private Connection con;
	public ContactDao() {
		con = DbConnection.getConnection();
	}

	public int addContact(Contact contact) {
		
		String q = "insert into contact value(?,?,?)";
		int n=0;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, contact.getId());
			ps.setString(2, contact.getcName());
			ps.setString(3, contact.getContactNo());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return n;
		
	}
	
	public List<Contact> contactList(){
		
		String q="select * from contact";
		
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet result = ps.executeQuery();
			List<Contact> contactList = new ArrayList<Contact>();
			while(result.next()) {
				int id = result.getInt(1);
				String cName = result.getString(2);
				String contactNo = result.getString(3);
				Contact contact = new Contact(id,cName,contactNo);
				contactList.add(contact);			
			}
			return contactList;	
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int deleteContact(int id) {
		String q = "delete from contact where id=?";
		int n=0;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, id);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;	
	}

	public Contact sreachContact(int id) {
		
		String q="select * from contact where id=?";
		Contact contact=null;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			if(result.next()) {
				int id2 = result.getInt(1);
				String cName = result.getString(2);
				String contactNo = result.getString(3);
				contact = new Contact(id2,cName,contactNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return contact;
		
	}

	public int updateContact(Contact contact) {
		String q = "update contact set c_name = ?,contact_no = ? where id = ?";
		int n=0;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, contact.getcName());
			ps.setString(2, contact.getContactNo());
			ps.setInt(3, contact.getId());
			n = ps.executeUpdate();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
		return n;
	}

}
