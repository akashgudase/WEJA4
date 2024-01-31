package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.MyResource;
import com.jspiders.multithreading.thread.MyThread6;
import com.jspiders.multithreading.thread.MyThread7;

public class ThreadMain5 {

	public static void main(String[] args) {

		MyResource myResource = new MyResource();

		MyThread6 myThread6 = new MyThread6(myResource);
		MyThread7 myThread7 = new MyThread7(myResource);

		myThread6.start();
		myThread7.start();

	}

}
