package com.jspiders.jdbc.main;

import java.util.Scanner;

import com.jspiders.jdbc.operations.JDBCService;

public class JDBCMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("Enter 1 to Sign up\nEnter 2 to Log in\nEnter 3 to exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				JDBCService.signUp(scanner);
				break;
			case 2:
				JDBCService.logIn(scanner);
				break;
			case 3:
				flag = false;
				System.out.println("Thank you");
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
		scanner.close();

	}

}
