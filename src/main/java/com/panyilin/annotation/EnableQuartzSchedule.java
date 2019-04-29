package com.panyilin.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.panyilin.config.ScheduleEnableConfig;

/**
 * @author panyl
 * 开启Quartz计划任务
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Configuration
@Import(ScheduleEnableConfig.class)
public @interface EnableQuartzSchedule {

	 
}
