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
        //#if (TARGET=="SOLUTION")
        return p -> p.isAdult();
        //#else
        //$return p -> true;
        //#endif
    }

    public static Predicate<Person> selectAdultPersonWithMethodReference() {
        //#if (TARGET=="SOLUTION")
        return Person::isAdult;
        //#else
        //$return p -> true;
        //#endif
    }

    public static Predicate<Person> selectFemaleOrMinorsWithCombinedPredicates() {
        //#if (TARGET=="SOLUTION")
        Predicate<Person> malePredicate = Person::isMale;
        Predicate<Person> adultPredicate = Person::isAdult;
        return malePredicate.negate().or(adultPredicate.negate());
        //#else
        //$return p -> true;
        //#endif
    }

    public static Predicate<Person> selectMinorPersonWithCombinedPredicates() {
        //#if (TARGET=="SOLUTION")
        Predicate<Person> malePredicate = Person::isMale;
        Predicate<Person> adultPredicate = Person::isAdult;
        return malePredicate.and(adultPredicate.negate());
        //#else
        //$return p -> true;
        //#endif
    }

    public static Function<Person, String> convertNameToUppercase() {
        //#if (TARGET=="SOLUTION")
        return p -> p.getName().toUpperCase();
        //#else
        //$return null;
        //#endif
    }

    public static BiFunction<String, String, String> comboString() {
        //#if (TARGET=="SOLUTION")
        return (String a, String b) -> a.length() < b.length() ? a + b + a : b + a + b;
        //#else
        //$return null;
        //#endif
    }

    public static BiFunction<Integer, Integer, Integer> sum() {
        return (i, j) -> i + j;
    }

    public static BiFunction<Integer, Integer, Integer> max() {
        //#if (TARGET=="SOLUTION")
        return Math::max;
        //#else
        //$return null;
        //#endif
    }

    public static Function<Integer, Integer> square() {
        //#if (TARGET=="SOLUTION")
        return i -> i * i;
        //#else
        //$return null;
        //#endif
    }

    public static Function<Integer, String> sumToString() {
        //#if (TARGET=="SOLUTION")
        Function<Integer, Integer> sum = i -> i + i;
        Function<Integer, String> toString = i -> i.toString();
        Function<Integer, String> chained = toString.compose(sum);
        return chained;
        //#else
        //$return null;
        //#endif
    }

    public static Consumer<Person> logWithConsumer() {
        SimpleLogger logger = SimpleLoggerFactory.getLogger(FunctionsLab.class);
        //#if (TARGET=="SOLUTION")
        return p -> logger.info(p);
        //#else
        //$return null;
        //#endif
    }

    public static Consumer<Person> logWithMethodReference() {
        SimpleLogger logger = SimpleLoggerFactory.getLogger(FunctionsLab.class);
        //#if (TARGET=="SOLUTION")
        return logger::info;
        //#else
        //$return null;
        //#endif
    }

    public static Comparator<Person> sortByName() {
        //#if (TARGET=="SOLUTION")
        return (p1, p2) -> p1.getName().compareTo(p2.getName());
        //#else
        //$return null;
        //#endif
    }

    public static Supplier<String> nameOfPersonWithLambdaSupplier(Person p) {
        //#if (TARGET=="SOLUTION")
        return () -> p.getName();
        //#else
        //$return null;
        //#endif
    }

    public static Supplier<String> nameOfPersonWithMethodReferenceSupplier(Person p) {
        //#if (TARGET=="SOLUTION")
        Supplier<String> supplier = p::getName;
        return supplier;
        //#else
        //$return null;
        //#endif
    }
}
