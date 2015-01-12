package com.xebia.java8_3.collections;

import com.xebia.domain.Person;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicCollectionsLabs {

    public static IntStream filterEvenNumbers(IntStream stream) {
        return stream.filter(i -> i % 2 == 0);
    }

    public static List<Person> filterAdults(List<Person> persons) {
        return persons.stream().filter(p -> p.isAdult()).collect(Collectors.toList());
    }

    public static List<String> filterMinorsAndExtractName(List<Person> persons) {
        return persons.stream().filter(p -> !p.isAdult()).map(p -> p.getName()).collect(Collectors.toList());
    }

    public static String timesAlphabet() {
    	return "";
    }

    public static List<String> extractAllHobbiesToUppercase(List<Person> persons) {
        return null;
    }

    public static int calculateTheSumOfARangeUsingReduce(List<Integer> integers) {
        return 0;
    }

    public static int sumAllAgesWithReducerFunction(List<Person> persons) {
        return 0;
    }

    public static int sumAgeWithMapFunction(List<Person> persons) {
        return 0;
    }

    public static int sumWithCollectors(List<Person> persons) {
        return 0;
    }

    public static Person findTheOldestPerson(List<Person> persons) {
        return null;
    }

    public static boolean allPersonsAboveAge(List<Person> persons, int minimumAge) {
        return false;
    }

    public static boolean containsFemale(List<Person> persons) {
        return false;
    }

    public static int calculateSafeMax(List<Integer> integers) {
        return 0;
    }



}
