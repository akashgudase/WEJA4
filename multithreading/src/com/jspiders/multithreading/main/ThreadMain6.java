package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.MyResource1;
import com.jspiders.multithreading.thread.MyThread8;
import com.jspiders.multithreading.thread.MyThread9;

public class ThreadMain6 {

	public static void main(String[] args) {

		MyResource1 myResource1 = new MyResource1();

		MyThread8 myThread8 = new MyThread8(myResource1);
		myThread8.setName("MyThread8");

		MyThread9 myThread9 = new MyThread9(myResource1);
		myThread9.setName("MyThread9");

		myThread8.start();
		myThread9.start();
	}
}
