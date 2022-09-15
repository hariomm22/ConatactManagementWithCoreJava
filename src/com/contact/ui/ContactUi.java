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
		if(n!=0) {
			System.out.println("Contact deleted which Id is "+id);
		} else {
			System.out.println("No Contact Exits which Id is "+id);
		}
	
	}

	public void sreachContactUi() {
		System.out.println("Enter the the contact ID which you want to sreach..");
		int id = sc.nextInt();
		Contact contact = contactDao.sreachContact(id);
		System.out.println(contact);
	}

	public void updateContactUi() {
		System.out.println("Enter the the contact ID which you want to Update..");
		int id = sc.nextInt();
		int status;
		Contact contact = contactDao.sreachContact(id);
		if(contact!=null) {
			System.out.println("Enter letest Contact name");
			String cName=sc.next();
			contact.setcName(cName);
			System.out.println("Enter letest Contact Number");
			String contactNo=sc.next();
			contact.setContactNo(contactNo);
			status=contactDao.updateContact(contact);
			if(status!=0) {
				System.out.println("updation done..!");
			} else {
				System.out.println("something happen Worng..!");
			}
		} else {
			System.out.println("No Contact Exits with Id "+id);
		}
	}
}
