package com.jspiders.designpatterns.main;

import java.util.Scanner;

import com.jspiders.designpatterns.creational.Beverage;
import com.jspiders.designpatterns.creational.GingerTea;
import com.jspiders.designpatterns.creational.GreenTea;
import com.jspiders.designpatterns.creational.LemonTea;
import com.jspiders.designpatterns.creational.MasalaTea;

public class FactoryMain {

	public static void main(String[] args) {

		try {
			factory().order();
		} catch (NullPointerException e) {
			System.out.println("No Tea ordered");
			e.printStackTrace();
		}

	}

	private static Beverage factory() {

		Beverage beverage = null;
		System.out.println("Enter 1 to order Masala Tea\nEnter 2 to order Green Tea" + "\nEnter 3 to order Lemon Tea"
				+ "\nEnter 4 to order Ginger Tea");
		System.out.println("Enter your choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		scanner.close();
		switch (choice) {
		case 1:
			beverage = new MasalaTea();
			break;
		case 2:
			beverage = new GreenTea();
			break;
		case 3:
			beverage = new LemonTea();
			break;
		case 4:
			beverage = new GingerTea();
			break;
		default:
			System.out.println("Invalid choice");
		}

		return beverage;

	}

}
