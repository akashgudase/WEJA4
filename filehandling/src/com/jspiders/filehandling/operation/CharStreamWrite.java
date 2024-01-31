package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamWrite {

	public static void main(String[] args) throws IOException {

		File file = new File("D:/File/Demo.txt");
		if (file.exists()) {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("Java is a programming language");
			System.out.println("Data is written to the file");
			fileWriter.close();
		} else {
			boolean status = file.createNewFile();
			if (status) {
				System.out.println("File is created");
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write("Java is programming language");
				System.out.println("Data is written to the file");
				fileWriter.close();
			} else {
				System.out.println("File is not created");
			}
		}

	}

}
