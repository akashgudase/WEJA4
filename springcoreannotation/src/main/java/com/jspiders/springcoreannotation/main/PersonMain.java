package com.jspiders.springcoreannotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcoreannotation.config.PersonConfig;
import com.jspiders.springcoreannotation.entity.Person;

public class PersonMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
		Person person1 = (Person) applicationContext.getBean("person");
		System.out.println(person1);
		Person person2 = (Person) applicationContext.getBean("person");
		System.out.println(person2);
		((AnnotationConfigApplicationContext) applicationContext).close();
	}

}
