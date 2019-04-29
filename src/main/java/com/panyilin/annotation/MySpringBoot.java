package com.panyilin.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author panyl
 * 自定义Springboot启动标签
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Configuration
@ComponentScan()
public @interface MySpringBoot {

	String value() default "springBootApplication";
}
