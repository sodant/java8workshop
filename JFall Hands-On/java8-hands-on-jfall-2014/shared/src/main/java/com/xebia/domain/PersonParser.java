package com.xebia.domain;

public class PersonParser {
	
	/**
	 * Parse a csv line to person
	 * @param line Name;Age;Male/Female;Role
	 * @return person
	 */
	public static Person parse(String line) {
		String[] values = line.split(";");
		if (values == null || values.length < 3) {
			throw new IllegalArgumentException(String.format("Line=[%s] cannot be parsed to Person", line));
		}
		return new Person(values[0], Integer.parseInt(values[1]), (Integer.parseInt(values[2]) == 1 ? true : false),
				Person.Role.valueOf(values[3]));
	}
}
