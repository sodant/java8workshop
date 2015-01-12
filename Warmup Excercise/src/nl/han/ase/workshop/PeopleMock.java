package nl.han.ase.workshop;

import java.util.Arrays;
import java.util.List;

public class PeopleMock {

	private static List<Person> people = Arrays.asList(
			new Person("Jan", Person.MALE, 24),
			new Person("Ariel", Person.FEMALE, 23),
			new Person("Lexie", Person.FEMALE, 18),
			new Person("Catherina", Person.FEMALE, 19),
			new Person("Kaya", Person.FEMALE, 30),
			new Person("Robinson", Person.MALE, 30),
			new Person("Brenda", Person.FEMALE, 23),
			new Person("Irving", Person.MALE, 22),
			new Person("Loick", Person.MALE, 22),
			new Person("Rachel", Person.FEMALE, 25)
			);
	
	public static List<Person> getPeople() {
		return people;
	}
	
}
