package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.entity.User;

public class UserMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("user_config.xml");
		User user = (User) applicationContext1.getBean("user1");
		System.out.println(user);
		((ClassPathXmlApplicationContext) applicationContext1).close();

		ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("user_config.xml");
		User user2 = (User) applicationContext2.getBean("user2");
		System.out.println(user2);
		((ClassPathXmlApplicationContext) applicationContext2).close();

		ApplicationContext applicationContext3 = new ClassPathXmlApplicationContext("user_config.xml");
		User user3 = (User) applicationContext3.getBean("user3");
		System.out.println(user3);
		((ClassPathXmlApplicationContext) applicationContext3).close();

	}

}
