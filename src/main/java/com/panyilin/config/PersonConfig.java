package com.panyilin.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.panyilin.thirdparty.beans.Person;

@Configuration
public class PersonConfig {
 
	
	@Bean
	@Qualifier("jack")
	public Person jack() {
		return new Person("jack", 1, 22);
	}
	
	@Bean
	@Qualifier("ruth")
	public Person ruth() {
		return new Person("ruth", 0, 18);
	}
}
