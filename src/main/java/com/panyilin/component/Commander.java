package com.panyilin.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.panyilin.thirdparty.beans.Person;
import com.panyilin.thirdparty.command.Command;
import com.panyilin.thirdparty.command.CommandRun;

@Component 
public class Commander {

	private static Logger logger = LoggerFactory.getLogger(CommandRun.class);
	
	@Autowired
	@Qualifier("jack")
	private Person person;

 
	@Autowired
	private Command c;
	
	@Bean
	private Command command(@Qualifier("ruth") Person p) {
		return new CommandRun(p);
	}
	
	
	public void sayHello() {
		logger.info("{} says hello to you", person.getName());
	}
	
	public void execute() {
		c.exec();
	}
}
