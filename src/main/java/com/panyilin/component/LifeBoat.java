package com.panyilin.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.panyilin.thirdparty.beans.Person;
import com.panyilin.thirdparty.command.Command;
import com.panyilin.thirdparty.command.CommandJump;

@Component 
public class LifeBoat {

	private static Logger logger = LoggerFactory.getLogger(LifeBoat.class);
	
	@Autowired
	@Qualifier("Rose")
	private Person person;

 
	@Autowired
	@Qualifier("jumpCommand")
	private Command c;
	
	@Bean
	@Qualifier("jumpCommand")
	private Command command(@Qualifier("Jack") Person p) {
		return new CommandJump(p);
	}
	
	public void whatHappened() {
		this.execute();
		this.stay();
	}

	private void stay() {
		logger.info("{} was sitting in the boat. And crying...", person.getName());
	}
	
	private void execute() {
		c.exec();
	}
}
