package com.panyilin;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.panyilin.annotation.EnableQuartzSchedule;
import com.panyilin.annotation.MySpringBoot;
import com.panyilin.component.Commander;

@EnableQuartzSchedule  
@MySpringBoot
public class MySpringBootApplication {
	private static Logger logger = LoggerFactory.getLogger(MySpringBootApplication.class);

	public static void main(String... args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(MySpringBootApplication.class);
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.stream(beanNames).forEach(logger::info);
		
		Commander a = context.getBean(Commander.class);
		a.sayHello();
		a.execute();
	}
}
