package humanresourcemanagement.data;

import java.time.LocalDate;
import java.util.ArrayList;

import humanresourcemanagement.humans.Human;
import humanresourcemanagement.humans.Student;

public class HumanMockAdapter implements IHumanDataAdapter {
	
	public ArrayList<Human> getAllHumans() {
		
		ArrayList<Human> humans = new ArrayList<Human>();
//		humans.add(new Student("Rachèl", LocalDate.of(1991, 11, 22)));
//		humans.add(new Student("Mick", LocalDate.of(1991, 1, 21)));
//		humans.add(new Student("Lex", LocalDate.of(1995, 4, 23)));
//		humans.add(new Student("Lars", LocalDate.of(1989, 8, 3)));
//		humans.add(new Student("Jenny", LocalDate.of(1996, 12, 28)));
		
		return humans;		
	}

}
