package humanresourcemanagement.humans;

import java.time.*;

public class Human {		
	public int age;
	public String name;
	public String sex;
	public LocalDate birthDate;
	
	public Human(String name, LocalDate birthDate, String sex) {
		this.name = name;
		this.birthDate = birthDate;
		this.sex = sex;

		this.age = Period.between(birthDate, LocalDate.now()).getYears();
	}

	public void print() {
		System.out.println(name + " " + age);
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean isAdult()
	{
		return age >= 18 ? true : false;
	}
	
	public boolean isMale()
	{
		return sex == "m";
	}


}
