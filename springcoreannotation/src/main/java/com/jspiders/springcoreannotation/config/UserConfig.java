package com.jspiders.springcoreannotation.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcoreannotation.entity.User;

public class UserConfig {

	@Bean(name = "user")
	public User getUser() {
		return new User();
	}

}
