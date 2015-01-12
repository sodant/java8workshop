package com.xebia.java8_3.collections;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;
import com.xebia.domain.Company;
import com.xebia.domain.Person;
import com.xebia.domain.Person.Role;

public class IntermediateCollectionsLab {
    

    public static List<Person> removeYoungestAndOldestChildrenFromList(List<Person> persons) {
        return persons;
    }

    public static Map<String, List<Person>> groupByNamesOfEmployee(List<Company> companies) {
        return new java.util.HashMap<String, List<Person>>();
    }
    
    public static Map<String, List<Person>> groupByAdultsAndMinors(List<Person> persons) {
        return null;
    }

    public static Collector<Person, StringJoiner, String> personToString() {
        return null;
    }
    
    public static Role findWhichRoleIsMostPopularAcrossCompanies(List<Company> companies) {
        return null;
    }

    public static Company findCompanyWithOldestEmployee(List<Company> companies) {
        return null;
    }

    public static <T> Stream<T> takeWhile(Stream<T> stream, Predicate<T> predicate) {
        return stream;
    }

    public static <A, B, C> Stream<C> zip(Stream<? extends A> a, Stream<? extends B> b,
            BiFunction<? super A, ? super B, ? extends C> zipFunction) {
        return null;
    }

    public static Stream<Integer> zipWithSum(Stream<Integer> s1, Stream<Integer> s2) {
        return null;
    }
    
}
