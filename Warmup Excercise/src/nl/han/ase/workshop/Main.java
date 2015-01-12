package nl.han.ase.workshop;

import java.util.List;

public class Main {
	
	private List<Person> people;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}	
	
	public Main() {
		// Get people from mock
		this.people = PeopleMock.getPeople();
		
		// Filter people
		List<Person> youngWoman = getFilteredList();
		
		// Print results
		printList(youngWoman);
	}
	
	public List<Person> getFilteredList() {
		// filter lijst op vrouwen met een leeftijd tussen 18 en 25 jaar (Java 7)
		return null;
	}
	
	private void printList(List<Person> people) {
		// print de gefilterde lijst (Java 7)
	}
}
