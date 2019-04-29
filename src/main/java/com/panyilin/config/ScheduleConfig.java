package com.panyilin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.panyilin.annotation.ConditionalOnScheduleMarker;
import com.panyilin.schedule.job.Job;
import com.panyilin.schedule.job.SimpleJob;

/**
 * @author panyl
 * Quartz Schedule 配置信息
 */
@ConditionalOnScheduleMarker
@Configuration
@Import({ScheduleProperties.class})
public class ScheduleConfig {

	// 进行注入我们的Job对象
	//@Bean
	public Job getMyJob() {
		return new SimpleJob();

	}

	//使用注入方式 
	@Autowired
	private Job job;
	
	@Autowired
	private ScheduleProperties prop;
	
	// 进行配置Spring的作业详情工厂类，我们所写的作业类都是给这个对象进行调用的
	@Bean
	public MethodInvokingJobDetailFactoryBean getMethodInvokingJobDetailFactoryBean() {
		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
		// 使用set方式注入
		bean.setTargetObject(job); // 定时执行的对象
		bean.setTargetMethod("run"); // 定时执行的方法
		return bean;

	}

	// 配置一个作业执行的触发器操作,cron表达式可以制定规定时间的执行
	@Bean
	public CronTriggerFactoryBean getCronTriggerFactoryBean() {
		CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
		bean.setJobDetail(getMethodInvokingJobDetailFactoryBean().getObject());// 注入作业详情
		bean.setCronExpression(prop.getCronExp());// Cron表达式
		return bean;
	}

	// 配置一个方法调试类
	@Bean
	public SchedulerFactoryBean getSchedulerFactoryBean() {
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		bean.setTriggers(getCronTriggerFactoryBean().getObject());
		return bean;
	}

}
