package humanresourcemanagement.humans;

import java.time.LocalDate;

public class Teacher extends Human {

	public Teacher(String name, LocalDate birthDate, String sex) {
		super(name, birthDate, sex);
	}		
	
	public void scoldStudent(Student target){
		
		System.out.println(target.name + "! You are late!");		
	}

}
