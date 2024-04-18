package com.jspiders.springcoreannotation.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Aadhar {
	
	{
		System.out.println("Aadhar");
	}

	@Value("1")
	private int id;
	@Value("123456789876")
	private long aadharNumber;

}
