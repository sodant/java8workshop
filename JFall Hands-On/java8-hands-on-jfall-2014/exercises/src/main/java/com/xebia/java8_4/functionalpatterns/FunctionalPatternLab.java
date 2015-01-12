package com.xebia.java8_4.functionalpatterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import com.xebia.domain.Person;
import com.xebia.domain.Person.Role;
import com.xebia.domain.PersonParser;

public class FunctionalPatternLab {


    public static class InheritanceApproach {

        public abstract static class PersonFilterTemplate {

            /**
             * Given imperative approach for filtering persons read from a URL.
             * The filtering logic is delegated to a subclass that implements
             * the abstract {@link PersonFilterTemplate.doFilterPerson} method.
             *
             * @param url
             *            pointing to resource with persons in csv format
             * @return filtered persons
             */
            public List<Person> filterPersonsImperativeImpl(URL url) {
                List<Person> collected = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
                    String csv = "";
                    while ((csv = br.readLine()) != null) {
                        Person person = PersonParser.parse(csv);
                        // filter person
                        if (doFilterPerson(person)) {
                            collected.add(person);
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return collected;
            }

            public List<Person> filterPersonsFunctionalImpl(URL url) {
                return null;
            }

            protected abstract boolean doFilterPerson(Person person);

        }

        /**
         * Concrete filter implementation
         */
        public static class ProgrammersFilter extends PersonFilterTemplate {
            @Override
            protected boolean doFilterPerson(Person person) {
                return person.getRole() == Role.PROGRAMMER;
            }
        }
    }

    public static class HigherOrderFunctionApproach {

        public static class FunctionalPersonFilter {

            public static List<Person> filterPersons(URL url, Predicate<Person> personFilter) {
                return null;
            }

        }
    }
}
