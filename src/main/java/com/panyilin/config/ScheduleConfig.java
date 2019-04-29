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
 * Quartz Schedule ������Ϣ
 */
@ConditionalOnScheduleMarker
@Configuration
@Import({ScheduleProperties.class})
public class ScheduleConfig {

	// ����ע�����ǵ�Job����
	//@Bean
	public Job getMyJob() {
		return new SimpleJob();

	}

	//ʹ��ע�뷽ʽ 
	@Autowired
	private Job job;
	
	@Autowired
	private ScheduleProperties prop;
	
	// ��������Spring����ҵ���鹤���࣬������д����ҵ�඼�Ǹ����������е��õ�
	@Bean
	public MethodInvokingJobDetailFactoryBean getMethodInvokingJobDetailFactoryBean() {
		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
		// ʹ��set��ʽע��
		bean.setTargetObject(job); // ��ʱִ�еĶ���
		bean.setTargetMethod("run"); // ��ʱִ�еķ���
		return bean;

	}

	// ����һ����ҵִ�еĴ���������,cron���ʽ�����ƶ��涨ʱ���ִ��
	@Bean
	public CronTriggerFactoryBean getCronTriggerFactoryBean() {
		CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
		bean.setJobDetail(getMethodInvokingJobDetailFactoryBean().getObject());// ע����ҵ����
		bean.setCronExpression(prop.getCronExp());// Cron���ʽ
		return bean;
	}

	// ����һ������������
	@Bean
	public SchedulerFactoryBean getSchedulerFactoryBean() {
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		bean.setTriggers(getCronTriggerFactoryBean().getObject());
		return bean;
	}

}
