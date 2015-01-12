package com.xebia.java8_5.defaultmethods;

import com.xebia.domain.SimpleLogger;
import com.xebia.domain.SimpleLoggerFactory;

public class DefaultMethodsLabs {

	public static class ServiceWithTraditionalLogger {
		public static final SimpleLogger LOG = SimpleLoggerFactory.getLogger(ServiceWithTraditionalLogger.class);

		public void process() {
			LOG.info("Hey I'm processing!");
		}
	}
	//#if (TARGET=="SOLUTION")
	public static class ServiceWithDefaultMethodLogger implements Loggable {
		public void process() {
			info("Hey I'm processing!");
		}
	}
	
	interface Loggable {
		default SimpleLogger logger() {
			return SimpleLoggerFactory.getLogger(getClass());
		}

		default void info(String s) {
			logger().info(s);
		}

	}
	//#else
	//$
	//$public static class ServiceWithDefaultMethodLogger  {
	//$public void process() {
	//$//log the same statement as above 		
	//$	}
	//$}
	//#endif

}
