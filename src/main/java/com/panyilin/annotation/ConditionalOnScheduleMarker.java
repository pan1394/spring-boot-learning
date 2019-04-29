package com.panyilin.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

import com.panyilin.condition.IsMarkerExisting;

/**
 * @author panyl
 * 计划任务开启条件 标签
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Conditional(IsMarkerExisting.class)
public @interface ConditionalOnScheduleMarker {

}
