package com.panyilin.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ScheduleSelector implements ImportSelector {

	private static final String selectorClass = "com.panyilin.config.ScheduleEnableConfig";
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] {selectorClass};
	}

}
