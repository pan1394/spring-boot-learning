package com.panyilin.thirdparty.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.panyilin.thirdparty.beans.Person;

public class CommandJump implements Command {
 
	private static Logger logger = LoggerFactory.getLogger(CommandCry.class);
	
	private Person p;
	
	public CommandJump(Person p) {
		super();
		this.p = p;
	}
	
	public void exec() {
		logger.info("System asks {} to jump into the iced see!", p.getName());
	}

}
