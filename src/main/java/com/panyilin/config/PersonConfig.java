package com.panyilin.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.panyilin.thirdparty.beans.Person;

@Configuration
@PropertySource(value={"classpath:application.properties"})
public class PersonConfig {
 
	@Bean
	@Qualifier("Jack")
	public Person jack(@Value("${person.jack.name}") String name,@Value("${person.jack.gender}") int gender, @Value("${person.jack.age}")  int age) {
		return new Person(name, gender, age);
	}
	
	@Bean
	@Qualifier("Rose")
	public Person ruth(@Value("${person.rose.name}") String name,@Value("${person.rose.gender}") int gender, @Value("${person.rose.age}")  int age) {
		return new Person(name, gender, age);
	}
}
