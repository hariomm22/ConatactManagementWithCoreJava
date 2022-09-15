package com.contact.ui;

import java.util.Scanner;

import com.contact.dao.UserDao;
import com.contact.model.User;

public class UserUi {
	
	private UserDao userDao;
	private ContactUi contactUi;

	public UserUi() {
		
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void init() {
		System.out.println("Enter the username");
		String username = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		userDao = new UserDao();
		if(userDao.login(username, password)) {
			this.userMenu();
		} else {
			System.out.println("Invalid username and password");
		}
	}
	
	
	public void userRegister() {
		System.out.println("Create new username");
		String username = sc.next();
		System.out.println("Create new password");
		String password = sc.next();
		User user = new User(0,username,password);
		userDao = new UserDao();
		userDao.register(user);
	}
	
	public void userMenu() {
		int choice;
		contactUi = new ContactUi();
		do {
			System.out.println("\n \n1 View the List of Contact");
			System.out.println("2 Add a new Contact");
			System.out.println("3 Update Contact");
			System.out.println("4 Delete Contact");
			System.out.println("5 Sreach Contact");
			System.out.println("0 Logout");
			System.out.print("Enter Ur choice  ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				
				contactUi.listOfContact();
				break;
			case 2:
				contactUi.addContactUi();
				break;
			case 3:
				System.out.println("Update of Contact");
				break;
			case 4:
				contactUi.deleteContactUi();
				break;
			case 5:
				System.out.println("Sreach of Contact");
				break;
			case 0:
				System.out.println("Logout..!");
				break;
			default:
				System.err.println("Worng Input");
			}
		} while(choice!=0);
		
	}

}
