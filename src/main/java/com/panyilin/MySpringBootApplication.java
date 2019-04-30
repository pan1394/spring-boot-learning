package com.panyilin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.panyilin.annotation.EnableQuartzSchedule;
import com.panyilin.annotation.MySpringBoot;
import com.panyilin.component.LifeBoat;

@EnableAspectJAutoProxy
@EnableQuartzSchedule  
@MySpringBoot
public class MySpringBootApplication {
	private static Logger logger = LoggerFactory.getLogger(MySpringBootApplication.class);

	public static void main(String... args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MySpringBootApplication.class);
		//String[] beanNames = context.getBeanDefinitionNames();
		//Arrays.stream(beanNames).forEach(logger::info);
		
		LifeBoat a = context.getBean(LifeBoat.class);
		a.whatHappened();
	}
}
