package com.panyilin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value={"classpath:application.properties"})
@Component
public class ScheduleProperties {

	@Value("${quartz.cron.expression}")
	private String cronExp;

	public String getCronExp() {
		return cronExp;
	}
	
	
}
