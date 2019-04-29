package com.panyilin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author panyl
 * Quartz Schedule 启用配置， 现在未用到。 无法在applicationcontext容器中发现scheduleMarker bean???
 */
@Configuration
public class ScheduleEnableConfig {

	@Bean("scheduleMarker")
	public Object marker() {
		return new Object();
	}
}
