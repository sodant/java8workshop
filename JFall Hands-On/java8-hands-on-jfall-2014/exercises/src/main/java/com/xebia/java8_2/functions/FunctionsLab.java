package com.xebia.java8_2.functions;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.xebia.domain.Person;
import com.xebia.domain.SimpleLogger;
import com.xebia.domain.SimpleLoggerFactory;

public class FunctionsLab {

    public static Predicate<Person> selectAdultPersonWithLambda() {
        
    	return p -> p.isAdult();
    }

    public static Predicate<Person> selectAdultPersonWithMethodReference() {
        return p -> true;
    }

    public static Predicate<Person> selectFemaleOrMinorsWithCombinedPredicates() {
        return p -> true;
    }

    public static Predicate<Person> selectMinorPersonWithCombinedPredicates() {
        return p -> true;
    }

    public static Function<Person, String> convertNameToUppercase() {
        return null;
    }

    public static BiFunction<String, String, String> comboString() {
        return null;
    }

    public static BiFunction<Integer, Integer, Integer> sum() {
        return (i, j) -> i + j;
    }

    public static BiFunction<Integer, Integer, Integer> max() {
        return null;
    }

    public static Function<Integer, Integer> square() {
        return null;
    }

    public static Function<Integer, String> sumToString() {
        return null;
    }

    public static Consumer<Person> logWithConsumer() {
        SimpleLogger logger = SimpleLoggerFactory.getLogger(FunctionsLab.class);
        return null;
    }

    public static Consumer<Person> logWithMethodReference() {
        SimpleLogger logger = SimpleLoggerFactory.getLogger(FunctionsLab.class);
        return null;
    }

    public static Comparator<Person> sortByName() {
        return null;
    }

    public static Supplier<String> nameOfPersonWithLambdaSupplier(Person p) {
        return null;
    }

    public static Supplier<String> nameOfPersonWithMethodReferenceSupplier(Person p) {
        return null;
    }
}
