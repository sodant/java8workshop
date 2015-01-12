package com.xebia.java8_4.functionalpatterns;

import static com.xebia.domain.Person.Role.PROGRAMMER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.xebia.domain.Person;

public class ImperativeToFunctionalLabs {


    public static class Lab1 {

        public static class Imperative {

            /**
             * Given imperative approach for filtering persons with role
             * Programmer, sorting them by name and group them by age
             *
             * @param persons
             *            list of persons
             * @return Map with key= age group (10, 20, 30 etc.) and value=List
             *         of Persons belonging to this group
             */
            public static Map<Integer, List<Person>> filterAndGroupPersons(List<Person> persons) {
                // filter programmers
                List<Person> programmers = new ArrayList<>();
                for (Person p : persons) {
                    if (p.getRole() == PROGRAMMER) {
                        programmers.add(p);
                    }
                }

                // sort
                Collections.sort(programmers, new Comparator<Person>() {
                    public int compare(Person p1, Person p2) {
                        return p1.getName().compareTo(p2.getName());
                    }
                });

                // group by age group
                Map<Integer, List<Person>> programmersPerAgeGroup = new HashMap<>();
                for (Person programmer : programmers) {
                    int ageGroup = programmer.getAge() / 10 * 10;
                    List<Person> ageGroupProgrammers =
                            programmersPerAgeGroup.getOrDefault(ageGroup, new ArrayList<Person>());
                    ageGroupProgrammers.add(programmer);
                    programmersPerAgeGroup.put(ageGroup, ageGroupProgrammers);
                }
                return programmersPerAgeGroup;
            }
        }

        public static class Functional {
            public static Map<Integer, List<Person>> filterAndGroupPersons(List<Person> persons) {
                //#if (TARGET=="SOLUTION")
                return persons.stream().filter(p -> p.getRole() == PROGRAMMER)
                        .sorted(Comparator.comparing(Person::getName))
                        .collect(Collectors.groupingBy(p -> p.getAge() / 10 * 10));
                //#else
                //$return null;
                //#endif
            }
        }
    }

    public static class Lab2 {

        public static class Imperative {

            /**
             * Given imperative approach for calculating the longest word in a
             * list of lines. The words in a line can be separated by a space.
             *
             * @param lines
             *            containing words separated by a space
             * @return length of longest word found
             */
            public static int calculateLengthOfLongestWord(List<String> lines) {

                int lengthLongestWord = 0;
                for (String line : lines) {
                    for (String word : line.split(" ")) {
                        if (word.length() > lengthLongestWord) {
                            lengthLongestWord = word.length();
                        }
                    }
                }
                return lengthLongestWord;
            }
        }

        public static class Functional {

            public static int calculateLengthOfLongestWord(List<String> lines) {
                //#if (TARGET=="SOLUTION")
                return lines
                        .stream()
                        .mapToInt(
                                line -> Arrays.asList(line.split(" ")).stream().mapToInt(String::length).max()
                                        .orElse(0)).max().orElse(0);
                //#else
                //$return 0;
                //#endif
            }

            /**
             * Enhance the functional approach above to execute in parallel
             *
             * @return length of longest word found
             */
            public static int calculateLengthOfLongestWordInParallel(List<String> lines) {
                //#if (TARGET=="SOLUTION")
                return lines
                        .parallelStream()
                        .mapToInt(
                                line -> Arrays.asList(line.split(" ")).stream().mapToInt(String::length).max()
                                        .orElse(0)).max().orElse(0);
                //#else
                //$return 0;
                //#endif
            }
        }
    }
}
