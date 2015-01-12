package com.xebia.domain;

import java.util.ArrayList;
import java.util.List;

public class SimpleLogger {
	
	private static final String LOG_FORMAT = "%s: %s";
	private static List<String> logged = new ArrayList<>();
	private final Class<?> className;
	
	protected SimpleLogger(Class<?> clazz) {
		this.className = clazz;
	}

	public void info(Object s) {
		logged.add(String.format(LOG_FORMAT, className, s));
	}

	protected Class<?> getLoggerClass() {
		return className;
	}
	
	public static boolean isLogged(String s) {
		return logged.stream().map(log -> log.substring(log.indexOf(":") + 2)).anyMatch(log -> log.equals(s));
	}

	public static void clear() {
		logged.clear();
	}

}

