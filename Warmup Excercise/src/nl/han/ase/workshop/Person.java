package nl.han.ase.workshop;

public class Person {

	public static int MALE = 2;
	public static int FEMALE = 1;
	public static int UNKNOWN = 0;
	
	private int sex = 0;
	private int age = 0;
	private String name = null;
	
	public Person(String name, int sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	public int getSex() {
		return this.sex;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}

}
