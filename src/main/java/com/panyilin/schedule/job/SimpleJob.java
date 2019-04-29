package com.panyilin.schedule.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author panyl
 * 一个计划任务 demo 
 */
@Component
public class SimpleJob implements Job {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void run() {
		logger.info("a sample task executed...");
	}

}
