package com.contact.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.contact.dao.ContactDao;
import com.contact.model.Contact;

public class ContactUi {

	private Scanner sc=new Scanner(System.in);
	private ContactDao contactDao = new ContactDao();
	public ContactUi() {
		// TODO Auto-generated constructor stub
	}

	public void addContactUi() {
		System.out.println("Enter the Contact Name");
		String cName = sc.next();
		System.out.println("Enter the Contact Number");
		String contactNo = sc.next();
		Contact contact = new Contact(0,cName,contactNo);
		int n=contactDao.addContact(contact);
		System.out.println(n+ " Contact Added..!");
	}
	
	public void listOfContact() {
		List<Contact> contactList = new ArrayList<Contact>();
		contactList = contactDao.contactList();
		System.out.println(contactList);
	}

	public void deleteContactUi() {
		System.out.println("Enter the Contact Id Which you want to delete");
		int id = sc.nextInt();
		int n = contactDao.deleteContact(id);
		System.out.println(n+ " Contact deleted..!");
	}
}
