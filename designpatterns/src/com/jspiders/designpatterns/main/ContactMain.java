package com.jspiders.designpatterns.main;

import com.jspiders.designpatterns.creational.Contact;
import com.jspiders.designpatterns.creational.ContactBuilder;

public class ContactMain {

	public static void main(String[] args) {

		Contact contact = new ContactBuilder().setFirstName("Ram")
				.setMobile(9877346645l).buildContact();
		System.out.println(contact);

	}

}
