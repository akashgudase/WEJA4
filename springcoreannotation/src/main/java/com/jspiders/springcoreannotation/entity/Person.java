package com.jspiders.springcoreannotation.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Scope(value = "prototype")
@Data
public class Person {
	
	{
		System.out.println("Person");
	}

	@Value("1")
	private int id;
	@Value("Ram")
	private String name;
	@Value("ram@gmail.com")
	private String email;
	@Autowired
	private Aadhar aadhar;
	@Autowired
	private PanCard panCard;

}
