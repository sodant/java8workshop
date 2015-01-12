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

    public static Persons filterUsingAnonymousInnerClass(Persons persons) {
        //#if (TARGET=="SOLUTION")
        return persons.filter(new PersonFilter() {
            @Override
            public boolean accept(Person person) {
                return person.isAdult();
            }
        });
        //#else
        //$return persons;
        //#endif
    }

    public static Persons filterWithLambda(Persons persons) {
        //#if (TARGET=="SOLUTION")
        return persons.filter(p -> p.isAdult());
        //#else
        //$return persons;
        //#endif
    }

    public static Persons filterWithMethodReference(Persons persons) {
        //#if (TARGET=="SOLUTION")
        return persons.filter(Person::isAdult);
        //#else
        //$return persons;
        //#endif
    }

    public static Persons filterMaleAdultsWithStaticMethodReference(Persons persons) {
        //#if (TARGET=="SOLUTION")
        return persons.filter(PersonSelector::maleAdults);
        //#else
        //$return persons;
        //#endif
    }

    public static Persons sortPersonsWithLambda(Persons persons) {
        //#if (TARGET=="SOLUTION")
        return persons.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        //#else
        //$return persons;
        //#endif
    }

    public static Persons sortWithComparing(Persons persons) {
        //#if (TARGET=="SOLUTION")
        return persons.sort(Comparator.comparing(Person::getName));
        //#else
        //$return persons;
        //#endif
    }

}
