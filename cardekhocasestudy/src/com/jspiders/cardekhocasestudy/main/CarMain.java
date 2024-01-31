package com.jspiders.cardekhocasestudy.main;

import java.util.Scanner;

import com.jspiders.cardekhocasestudy.operation.CarOperation;

public class CarMain {

	private static CarOperation carOperation = new CarOperation();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		boolean flag = true;
		while (flag) {
			System.out.println(
					"Enter 1 to add a car\nEnter 2 to search car by id\nEnter 3 to fetch all cars\nEnter 4 to delete a car\nEnter 5 to update car price\nEnter 6 to exit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				carOperation.addCar(scanner);
				break;
			case 2:
				carOperation.findCarById(scanner);
				break;
			case 3:
				carOperation.findAllCars();
				break;
			case 4:
				carOperation.deleteCar(scanner);
				break;
			case 5:
				carOperation.updateCar(scanner);
				break;
			case 6:
				flag = false;
				System.out.println("Thank You");
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
		scanner.close();

	}

}
