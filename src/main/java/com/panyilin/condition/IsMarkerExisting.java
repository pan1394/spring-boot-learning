package com.panyilin.condition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.panyilin.annotation.EnableQuartzSchedule;

/**
 * 查看主类上是否存在 <link>EnableQuartzSchedule<link>
 * @author panyl
 *
 */
public class IsMarkerExisting implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
 		BeanFactory beanFactory = context.getBeanFactory();
 		Object bean = beanFactory.getBean("springBootApplication");
 		return bean.getClass().isAnnotationPresent(EnableQuartzSchedule.class);
	}

}
