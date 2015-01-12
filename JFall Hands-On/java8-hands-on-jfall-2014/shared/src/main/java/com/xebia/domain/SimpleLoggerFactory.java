package com.xebia.domain;

import java.util.ArrayList;
import java.util.List;

public class SimpleLoggerFactory {
	
	private static List<SimpleLogger> loggers = new ArrayList<>();
	
	public static SimpleLogger getLogger(Class<?> clazz) {
		return loggers.stream().filter(logger -> logger.getLoggerClass() == clazz).findFirst().orElse(createAndAdd(clazz));
	}
	
	private static SimpleLogger createAndAdd(Class<?> clazz) {
		SimpleLogger logger = new SimpleLogger(clazz);
		loggers.add(logger);
		return logger;
	}
}