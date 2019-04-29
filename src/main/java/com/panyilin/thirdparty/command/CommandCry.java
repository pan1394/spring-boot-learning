package com.panyilin.thirdparty.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.panyilin.thirdparty.beans.Person;

public class CommandCry implements Command {
 
	private static Logger logger = LoggerFactory.getLogger(CommandCry.class);
	
	private Person p;
	 
	public CommandCry(Person p) {
		super();
		this.p = p;
	}
 
	public void exec() {
		logger.info("System asks {} to cry for helping...", p.getName());
	}

}
