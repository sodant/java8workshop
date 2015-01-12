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
	
	public static class ServiceWithDefaultMethodLogger  {
	public void process() {
	//log the same statement as above
		}
	}

}
