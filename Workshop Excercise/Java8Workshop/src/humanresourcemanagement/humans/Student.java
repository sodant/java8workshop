package humanresourcemanagement.humans;

import java.time.LocalDate;

public class Student extends Human {
	public int daysAbsent = 0;
	
	public Student(String name, LocalDate birthDate, String sex) {
		super(name, birthDate ,sex);
	}
	
	public void increaseAmountOfDaysAbsent(int amount) {
		daysAbsent += amount;
	}
	public void printDaysAbsent() {
		System.out.println(name + " has " + daysAbsent + " days absent");
	}
	
}
