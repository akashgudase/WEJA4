package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.entity.Person;

public class PersonMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("person_config.xml");
		Person person = (Person)applicationContext.getBean("person");
		System.out.println(person);
		((ClassPathXmlApplicationContext)applicationContext).close();
		
	}

}
