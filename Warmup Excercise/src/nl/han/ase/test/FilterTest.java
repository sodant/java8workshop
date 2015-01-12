package nl.han.ase.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import nl.han.ase.workshop.Main;
import nl.han.ase.workshop.Person;

import org.junit.Test;

public class FilterTest {
	
	@Test
	public void assertThatFilteredListContainsFemalesWithTheAgeBetween18And25() {
		List<Person> result = new Main().getFilteredList();
		List<Person> expected = Arrays.asList(
				new Person("Ariel", Person.FEMALE, 23),
				new Person("Lexie", Person.FEMALE, 18),
				new Person("Catherina", Person.FEMALE, 19),
				new Person("Brenda", Person.FEMALE, 23),
				new Person("Rachel", Person.FEMALE, 25)
		);
		assertEquals(result.size(), expected.size());
		assertEquals(result.get(0).getName(), expected.get(0).getName());
		assertEquals(result.get(1).getName(), expected.get(1).getName());
		assertEquals(result.get(2).getName(), expected.get(2).getName());
		assertEquals(result.get(3).getName(), expected.get(3).getName());
		assertEquals(result.get(4).getName(), expected.get(4).getName());
	}
}
