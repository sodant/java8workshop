package com.xebia.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Person {

	private final String name;
	private final int age;
	private final boolean male;
	private final Role role;
	private final List<String> hobbies;

	public Person(String name, int age, boolean isMale) {
		this.age = age;
		this.name = name;
		this.male = isMale;
		this.role = Role.UNKOWN;
		this.hobbies = new ArrayList<>();
	}
	
	public Person(String name, int age, boolean isMale, Role role) {
		this.age = age;
		this.name = name;
		this.male = isMale;
		this.role = role;
		this.hobbies = new ArrayList<>();
	}

	public Person(String name, int age, boolean isMale, Role role, String... hobby) {
		this.age = age;
		this.name = name;
		this.male = isMale;
		this.role = role;
		this.hobbies = Arrays.asList(hobby);
	}

	public int getAge() {
		return age;
	}

	public boolean isMale() {
		return male;
	}

	public String getName() {
		return name;
	}

	public boolean isAdult() {
		return age >= 18;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public Role getRole() {
		return role;
	}

	public String toString() {
		return String.format("Person[name=%s, age=%s, role=%s, hobbies=%s]", name, age, role, hobbies);
	}

	public enum Role {
		PROGRAMMER, SCRUMMASTER, ARCHITECT, PROJECT_MANAGER, TESTER, UNKOWN;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((hobbies == null) ? 0 : hobbies.hashCode());
		result = prime * result + (male ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (hobbies == null) {
			if (other.hobbies != null)
				return false;
		} else if (!hobbies.equals(other.hobbies))
			return false;
		if (male != other.male)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (role != other.role)
			return false;
		return true;
	}




}
