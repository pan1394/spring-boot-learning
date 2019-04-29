package com.panyilin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author panyl
 * Quartz Schedule �������ã� ����δ�õ��� �޷���applicationcontext�����з���scheduleMarker bean???
 */
@Configuration
public class ScheduleEnableConfig {

	@Bean("scheduleMarker")
	public Object marker() {
		return new Object();
	}
}
