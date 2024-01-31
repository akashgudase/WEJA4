package com.jspiders.multithreading.resource;

public class Food {

	private boolean available;

	public synchronized void order() {

		System.out.println("Order is received");
		if (available) {
			System.out.println("Order delivered");
		} else {
			System.out.println("Food is not available");
			System.out.println("Wait for some time..");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (available) {
				System.out.println("Order is delivered");
			}
		}

	}

	public synchronized void prepare() {

		System.out.println("Food is getting prepared");
		System.out.println("Food is prepared");
		available = true;
		notify();

	}

}
