package com.xebia.java8_5.defaultmethods;

import com.xebia.domain.SimpleLogger;
import com.xebia.java8_5.defaultmethods.DefaultMethodsLabs.ServiceWithDefaultMethodLogger;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DefaultMethodsLabsTest {


	public void setUp() throws Exception {
		SimpleLogger.clear();
	}

	@Test
	public void shouldProvideLoggerMethodsInLoggableInterface() {
		ServiceWithDefaultMethodLogger service = new ServiceWithDefaultMethodLogger();
		service.process();
		assertTrue(SimpleLogger.isLogged("Hey I'm processing!"));
		//the solution must not contain an instance variable of SimpleLogger
		assertFalse(hasSimpleLoggerInstanceVariable(service.getClass()));
	}

	private boolean hasSimpleLoggerInstanceVariable(Class<?> clazz) {
		return Arrays.asList(clazz.getDeclaredFields()).stream().anyMatch(f -> f.getType() == SimpleLogger.class);
	}
}

