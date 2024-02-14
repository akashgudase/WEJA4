package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsert3 {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;

	public static void main(String[] args) {

		try {
			openConnection();
			query = "INSERT INTO user VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			Scanner scanner = new Scanner(System.in);
			System.out.println("How many records you want to insert?");
			int count = scanner.nextInt();
			for (int i = 1; i <= count; i++) {
				System.out.println("Enter user id");
				int id = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter user name");
				String name = scanner.nextLine();
				System.out.println("Enter user email");
				String email = scanner.nextLine();
				System.out.println("Enter user password");
				String password = scanner.nextLine();
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, email);
				preparedStatement.setString(4, password);
				preparedStatement.addBatch();
			}
			scanner.close();
			int[] res = preparedStatement.executeBatch();
			System.out.println(res.length + " row(s) affected");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private static void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "root");
	}

	private static void closeConnection() throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

}
