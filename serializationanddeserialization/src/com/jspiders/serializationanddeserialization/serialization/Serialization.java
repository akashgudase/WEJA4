package com.jspiders.serializationanddeserialization.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.jspiders.serializationanddeserialization.object.User;

public class Serialization {

	public static void main(String[] args) throws IOException {

		File file = new File("D:/File/Demo.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(new User(1, "Ram", "ram@gmail.com", 9866453456l));
		System.out.println("Object has been serialized");
		objectOutputStream.close();
		fileOutputStream.close();

	}

}
