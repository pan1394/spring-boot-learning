package com.panyilin.schedule.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.panyilin.thirdparty.beans.Person;
import com.panyilin.thirdparty.command.Command;
import com.panyilin.thirdparty.command.CommandCry;

/**
 * @author panyl
 * 一个计划任务 demo 
 */
@Component
public class SimpleJob implements Job {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Bean
	private Command cryCommand(@Qualifier("Rose") Person p) {
		return new CommandCry(p);
	}
	
	@Autowired
	@Qualifier("cryCommand")
	private Command cryCommand;
	
	public void run() {
		cryCommand.exec();
	}

}
