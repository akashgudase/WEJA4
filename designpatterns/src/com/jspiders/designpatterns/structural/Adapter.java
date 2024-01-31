package com.jspiders.designpatterns.structural;

public class Adapter extends Employee implements Event {

	@Override
	public void womensDay() {

System.out.println("The chief guest for the Women's Day is " + getName());

	}

	@Override
	public void mensDay() {

System.out.println("The chief guest for the Men's Day is " + getName());

	}

}
