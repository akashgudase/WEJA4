package com.jspiders.springcoreannotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcoreannotation.config.UserConfig;
import com.jspiders.springcoreannotation.config.UserConfig2;
import com.jspiders.springcoreannotation.entity.User;

public class UserMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(UserConfig.class);
		User user1 = applicationContext1.getBean(User.class);
		System.out.println(user1);
		((AnnotationConfigApplicationContext) applicationContext1).close();

		ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(UserConfig.class);
		User user2 = (User) applicationContext2.getBean("user");
		System.out.println(user2);
		((AnnotationConfigApplicationContext) applicationContext2).close();

		ApplicationContext applicationContext3 = new AnnotationConfigApplicationContext(
				"com.jspiders.springcoreannotation");
		User user3 = (User) applicationContext3.getBean("user");
		System.out.println(user3);
		((AnnotationConfigApplicationContext) applicationContext3).close();

		ApplicationContext applicationContext4 = new AnnotationConfigApplicationContext(UserConfig2.class);
		User user4 = (User) applicationContext4.getBean("user");
		System.out.println(user4);
		((AnnotationConfigApplicationContext) applicationContext4).close();
	}

}
