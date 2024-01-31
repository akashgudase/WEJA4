package com.jspiders.designpatterns.structural;

public class AdapterMain {

	public static void main(String[] args) {

		Adapter adapter = new Adapter();
		adapter.setName("Ramesh");
		adapter.mensDay();
		adapter.setName("Roma");
		adapter.womensDay();

	}

}
