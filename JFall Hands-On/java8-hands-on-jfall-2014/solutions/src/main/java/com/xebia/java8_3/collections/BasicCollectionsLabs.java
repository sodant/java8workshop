package com.xebia.java8_3.collections;

import com.xebia.domain.Person;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summingInt;

public class BasicCollectionsLabs {

    public static IntStream filterEvenNumbers(IntStream stream) {
        //#if (TARGET=="SOLUTION")
        return stream.filter(i -> i % 2 == 0);
        //#else
        //$return stream;
        //#endif
    }

    public static List<Person> filterAdults(List<Person> persons) {
        //#if (TARGET=="SOLUTION")
        return persons.stream().filter(Person::isAdult).collect(Collectors.toList());
        //#else
        //$return null;
        //#endif
    }

    public static List<String> filterMinorsAndExtractName(List<Person> persons) {
        //#if (TARGET=="SOLUTION")
        return persons.stream().filter(p -> !p.isAdult()).map(Person::getName).collect(Collectors.toList());
        //#else
        //$return null;
        //#endif
    }

    public static String timesAlphabet() {
        //#if (TARGET=="SOLUTION")
        Stream<Character> characterStream = IntStream.rangeClosed(1, 26).flatMap(i -> IntStream.iterate(i, j -> j) //
                .limit(i)) //
                .mapToObj(s -> (char) (s + 96));
        return characterStream.map(c -> c.toString()).collect(Collectors.joining(","));
        //#else
        //$return "";
        //#endif
    }

    public static List<String> extractAllHobbiesToUppercase(List<Person> persons) {
        //#if (TARGET=="SOLUTION")
        return persons.stream().flatMap(//
                p -> p.getHobbies().stream().map((String s) -> s.toUpperCase())).distinct()
                .collect(Collectors.toList());
        //#else
        //$return null;
        //#endif
    }

    public static int calculateTheSumOfARangeUsingReduce(List<Integer> integers) {
        //#if (TARGET=="SOLUTION")
        return integers.stream().reduce((i, j) -> i + j).get();
        //#else
        //$return 0;
        //#endif
    }

    public static int sumAllAgesWithReducerFunction(List<Person> persons) {
        //#if (TARGET=="SOLUTION")
        //Inlining the sum function crashes the compiler
        BiFunction<Integer, Person, Integer> sum = (s, p) -> s += p.getAge();
        return persons.stream().reduce(0, sum, Integer::sum);
        //#else
        //$return 0;
        //#endif
    }

    public static int sumAgeWithMapFunction(List<Person> persons) {
        //#if (TARGET=="SOLUTION")
        return persons.stream().mapToInt(Person::getAge).sum();
        //#else
        //$return 0;
        //#endif
    }

    public static int sumWithCollectors(List<Person> persons) {
        //#if (TARGET=="SOLUTION")
        return persons.stream().collect(summingInt(Person::getAge));
        //#else
        //$return 0;
        //#endif
    }

    public static Person findTheOldestPerson(List<Person> persons) {
        //#if (TARGET=="SOLUTION")
        return persons.stream().collect(maxBy(comparingInt(Person::getAge))).get();
        //#else
        //$return null;
        //#endif
    }

    public static boolean allPersonsAboveAge(List<Person> persons, int minimumAge) {
        //#if (TARGET=="SOLUTION")
        return persons.stream().allMatch(p -> p.getAge() > minimumAge);
        //#else
        //$return false;
        //#endif
    }

    public static boolean containsFemale(List<Person> persons) {
        //#if (TARGET=="SOLUTION")
        return persons.stream().anyMatch(p -> !p.isMale());
        //#else
        //$return false;
        //#endif
    }

    public static int calculateSafeMax(List<Integer> integers) {
        //#if (TARGET=="SOLUTION")
        return integers.stream().mapToInt(i -> i).max().orElse(0);
        //#else
        //$return 0;
        //#endif
    }



}
