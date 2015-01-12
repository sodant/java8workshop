package com.xebia.java8_4.functionalpatterns;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import java.net.URL;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import com.xebia.domain.Person;
import com.xebia.domain.Person.Role;
import com.xebia.java8_4.functionalpatterns.FunctionalPatternLab.HigherOrderFunctionApproach.FunctionalPersonFilter;
import com.xebia.java8_4.functionalpatterns.FunctionalPatternLab.InheritanceApproach.PersonFilterTemplate;
import com.xebia.java8_4.functionalpatterns.FunctionalPatternLab.InheritanceApproach.ProgrammersFilter;

public class FunctionalPatternLabsTest {

	private URL csvUrl;

	@Before
	public void setUp() throws Exception {
		csvUrl = getClass().getResource("/persons.csv");
	}

	@Test
	public void exercise_1_ShouldFilterProgrammersUsingAFunctionalImplementation() {
		List<Person> expected = new ProgrammersFilter().filterPersonsImperativeImpl(csvUrl);
		List<Person> result = new ProgrammersFilter().filterPersonsFunctionalImpl(csvUrl);
		assertThat(result, equalTo(expected));
	}

	/**
	 * Instruction: Implement 
	 * the higher order function {@link FunctionalPersonFilter.filterPerson}. In this functional implementation the
	 * filtering logic can directly be defined as a {@link Predicate} without the need to implement an 
	 * abstract method like in the {@link PersonFilterTemplate} example.
	 * Hint: Most of the processing logic written in exercise 1 (see above) can be re-used.
	 */
	@Test
	public void exercise_2_shouldUseHigherOrderFunctionToFilterPersonsDynamicallyWithPredicate() {
		List<Person> expected = new ProgrammersFilter().filterPersonsImperativeImpl(csvUrl);
		List<Person> result = FunctionalPersonFilter.filterPersons(csvUrl, p -> p.getRole() == Role.PROGRAMMER);
		assertThat(result, equalTo(expected));
	}

}