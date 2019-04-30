package com.panyilin.thirdparty.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.panyilin.annotation.Recording;
import com.panyilin.thirdparty.beans.Person;

public class CommandCry implements Command {
 
	private static Logger logger = LoggerFactory.getLogger(CommandCry.class);
	
	private Person p;
	 
	public CommandCry(Person p) {
		super();
		this.p = p;
	}
 
	@Recording
	public void exec() {
		logger.info("{} was crying for helping...", p.getName());
	}

}
