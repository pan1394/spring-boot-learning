package com.panyilin.thirdparty.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.panyilin.thirdparty.beans.Person;

public class CommandWalk implements Command {
 
	private static Logger logger = LoggerFactory.getLogger(CommandRun.class);
	
	private Person p;
	
	public CommandWalk(Person p) {
		super();
		this.p = p;
	}
	
	public void exec() {
		logger.info("System asks {} to walk", p.getName());
	}

}
