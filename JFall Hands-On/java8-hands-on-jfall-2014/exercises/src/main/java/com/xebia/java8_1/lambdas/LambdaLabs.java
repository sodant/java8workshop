package com.xebia.java8_1.lambdas;

import java.util.Comparator;

import com.xebia.domain.Person;
import com.xebia.domain.Persons;
import com.xebia.domain.Persons.PersonFilter;

public class LambdaLabs {

    public static class PersonSelector {

        public static boolean maleAdults(Person person) {
            return person.isAdult() && person.isMale();
        }

        public static boolean femaleAdults(Person person) {
            return !maleAdults(person);
        }
    }
    
    public boolean personSelecterMethodReference(Person person) {
    	return person.isAdult();
    }

    public static Persons filterUsingAnonymousInnerClass(Persons persons) { 
        return persons.filter(new PersonFilter() {

			@Override
			public boolean accept(Person p1) {
				// TODO Auto-generated method stub
				return p1.isAdult();
			}
        	
        });
    }

    public static Persons filterWithLambda(Persons persons) {
        return persons.filter( p1 -> p1.isAdult());
    }

    public static Persons filterWithMethodReference(Persons persons) {
        return persons.filter(Person::isAdult);
    }

    public static Persons filterMaleAdultsWithStaticMethodReference(Persons persons) {
        return persons.filter(PersonSelector::maleAdults);
    }

    public static Persons sortPersonsWithLambda(Persons persons) {
        return persons.sort( (p1, p2) -> p1.getName().compareTo(p2.getName()) );
    }
    
    public static Persons sortWithComparing(Persons persons) {
        return persons.sort(Comparator.comparing(Person::getName));
    }

}
