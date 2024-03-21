package com.jspiders.springcoreannotation.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class User {

	@Value("1")
	private int id;
	@Value("ramesh")
	private String userName;
	@Value("ramesh@gmail.com")
	private String email;
	@Value("Ramesh@1234")
	private String password;

}
