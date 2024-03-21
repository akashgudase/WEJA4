package com.jspiders.springcoreannotation.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PanCard {
	
	@Value("1")
	private int id;
	@Value("ABC1234")
	private String pan;

}
