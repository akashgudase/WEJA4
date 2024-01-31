package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.MyThread5;

public class ThreadMain4 {

	public static void main(String[] args) {

		MyThread5 myThread5 = new MyThread5();
		myThread5.setName("MyThread5");
		myThread5.setPriority(8);
		myThread5.start();

	}

}
