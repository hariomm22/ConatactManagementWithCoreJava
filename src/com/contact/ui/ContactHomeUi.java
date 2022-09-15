package com.contact.ui;

import java.util.Scanner;

public class ContactHomeUi {

	private static Scanner sc;
	private static UserUi userUi;
	public ContactHomeUi() {
		 
	}
	static {
		userUi = new UserUi();
	}
    
	public static void main(String[] args) {
		
		    sc = new Scanner(System.in);
			Integer choice;
			System.out.println("Welcome in Contact Management Application");
			
			do {
				System.out.println("\n \n1 Login ");
				System.out.println("2 Register");
				System.out.println("0 Exit");
				System.out.println("Enter Ur Choice  ");
				choice=sc.nextInt();
				switch(choice) {
				case 1:
					userUi.init();
					break;
				case 2:
					userUi.userRegister();
					break;
				case 0:
					System.out.println("Bye Bye");
					break;
				default:
					System.err.println("Worng Input");
				}
				
			}while(choice!=0);
		}
		

}
