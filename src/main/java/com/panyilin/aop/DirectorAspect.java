package com.panyilin.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DirectorAspect {

	Logger logger = LoggerFactory.getLogger(DirectorAspect.class);
	
	@Pointcut("@annotation(com.panyilin.annotation.Recording)")
	public void record() { }
	
	@Pointcut("execution(* com.panyilin.thirdparty.command.CommandJump.exec(..))")
	public void cut() {}
	
	@Before("record()")
	public void beforeAdvice(JoinPoint jointPoint) {
		logger.info("Director is photographing...");
	}
	
	
	@After("cut()")
	public void afterAdvice(JoinPoint jointPoint) {
		logger.info("Director shouts, CUT!");
	}
	
}
