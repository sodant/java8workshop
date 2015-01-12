package com.xebia.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 * Immutable wrapper class for a collection of {@link Person} 
 * that provides additional methods for filtering and sorting
 */
public class Persons {
	private final List<Person> persons;

	public Persons(Person... args) {
		this.persons = Arrays.asList(args);
	}

	public Persons(List<Person> args) {
		this.persons = args;
	}

	/**
	 * Filter Persons based on the {@link PersonFilter} implementation provided.
	 * @param personFilter predicate that contains filter logic
	 * @return Persons containing all persons for the given filter
	 */
	public Persons filter(PersonFilter personFilter) {
		List<Person> filtered = new ArrayList<Person>();
		for (Person person : persons) {
			if (personFilter.accept(person)) {
				filtered.add(person);
			}
		}
		return new Persons(filtered);
	}
	/**
	 * Sort the all persons based on the given {@link Comparator}
	 * @param comparator with sorting logic
	 * @return new sorted Persons object 
	 */
	public Persons sort(Comparator<Person> comparator) {
		persons.sort(comparator);
		return new Persons(persons);
	}

	@Override
	public boolean equals(Object other) {
		return persons.equals(((Persons) other).persons);
	}

	public String toString() {
		return String.format("Persons=[%s]", persons);
	}

	/**
	 * This class represents a Filter Predicate for Persons.
	 */
	@FunctionalInterface
	public interface PersonFilter {

		/**
		 * Tests whether or not the specified person should be included in
		 * persons list.
		 * 
		 * @param person
		 *            The person to be tested
		 * @return <code>true</code> if and only if <code>person</code> should
		 *         be included
		 */
		public boolean accept(Person person);
	}

	/**
	 * Person Selector with predefined filters
	 */
	public static class PersonSelector {

		/**
		 * Filter for male adults
		 * 
		 * @param person
		 *            person
		 * @return true if person is a male adult
		 */
		public static boolean maleAdults(Person person) {
			return person.isAdult() && person.isMale();
		}

		/**
		 * Filter for female adults
		 * 
		 * @param person
		 *            person
		 * @return true if person is female adult
		 */
		public static boolean femaleAdults(Person person) {
			return person.isAdult() && !person.isMale();
		}
	}
}
