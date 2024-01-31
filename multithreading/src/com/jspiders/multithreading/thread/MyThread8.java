package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.MyResource1;

public class MyThread8 extends Thread {

	private MyResource1 myResource1;

	public MyThread8(MyResource1 myResource1) {
		this.myResource1 = myResource1;
	}

	@Override
	public void run() {
		myResource1.resource();
	}

}
