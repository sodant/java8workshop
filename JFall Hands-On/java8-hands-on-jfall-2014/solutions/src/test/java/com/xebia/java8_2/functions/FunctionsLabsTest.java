package com.xebia.java8_2.functions;

import static com.xebia.domain.Person.Role.PROGRAMMER;
import static com.xebia.domain.Person.Role.TESTER;
import static com.xebia.java8_2.functions.FunctionsLab.convertNameToUppercase;
import static com.xebia.java8_2.functions.FunctionsLab.logWithConsumer;
import static com.xebia.java8_2.functions.FunctionsLab.logWithMethodReference;
import static com.xebia.java8_2.functions.FunctionsLab.max;
import static com.xebia.java8_2.functions.FunctionsLab.nameOfPersonWithLambdaSupplier;
import static com.xebia.java8_2.functions.FunctionsLab.nameOfPersonWithMethodReferenceSupplier;
import static com.xebia.java8_2.functions.FunctionsLab.selectAdultPersonWithLambda;
import static com.xebia.java8_2.functions.FunctionsLab.selectAdultPersonWithMethodReference;
import static com.xebia.java8_2.functions.FunctionsLab.selectFemaleOrMinorsWithCombinedPredicates;
import static com.xebia.java8_2.functions.FunctionsLab.sortByName;
import static com.xebia.java8_2.functions.FunctionsLab.square;
import static com.xebia.java8_2.functions.FunctionsLab.sum;
import static com.xebia.java8_2.functions.FunctionsLab.sumToString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Before;
import org.junit.Test;

import com.xebia.domain.Person;
import com.xebia.domain.Persons;
import com.xebia.domain.SimpleLogger;

public class FunctionsLabsTest {

    private Person p1;
    private Person p2;
    private Person p3;
    private Persons persons;

    @Before
    public void setUp() throws Exception {
        p1 = new Person("Jack", 31, true, PROGRAMMER);
        p2 = new Person("Benjamin", 12, true, PROGRAMMER);
        p3 = new Person("Suse", 37, false, TESTER);
        persons = new Persons(p1, p2, p3);
    }

    @Test
    public void shouldSelectAdultPersonWithLambda() {
        assertTrue(selectAdultPersonWithLambda().test(p1));
        assertFalse(selectAdultPersonWithLambda().test(p2));
    }

    @Test
    public void shouldSelectAdultPersonWithMethodReference() {
        assertTrue(selectAdultPersonWithMethodReference().test(p1));
        assertFalse(selectAdultPersonWithMethodReference().test(p2));
    }

    @Test
    public void shouldSelectFemaleOrMinorsWithCombinedPredicates() {
        Predicate<Person> combinedFemaleOrMinors = selectFemaleOrMinorsWithCombinedPredicates();
        assertTrue(combinedFemaleOrMinors.test(p2));
        assertTrue(combinedFemaleOrMinors.test(p3));
        assertFalse(combinedFemaleOrMinors.test(p1));
    }

    @Test
    public void shouldSelectMinorPersonWithCombinedPredicates() {
        Predicate<Person> combinedPredicate = FunctionsLab.selectMinorPersonWithCombinedPredicates();

        assertTrue(combinedPredicate.test(p2));
        assertFalse(combinedPredicate.test(p1));
        assertFalse(combinedPredicate.test(p3));
    }

    @Test
    public void shouldConvertNameToUppercase() {
        assertThat(convertNameToUppercase().apply(p1), equalTo("JACK"));
    }

    @Test
    public void comboString() {
        assertThat(FunctionsLab.comboString().apply("aaa", "bb"), equalTo("bbaaabb"));
    }

    @Test
    public void shouldCalculateSum() {
        assertThat(sum().apply(2, 5), equalTo(7));
    }

    @Test
    public void shouldCalculateMax() {
        assertEquals(new Integer(200), max().apply(100, 200));
    }

    @Test
    public void shouldCalculateSquare() {
        assertEquals(new Integer(4), square().apply(2));
    }

    @Test
    public void shouldCalculateSumAndConvertToString() {
        assertThat(sumToString().apply(2), equalTo("4"));
    }

    @Test
    public void shouldLogToStringOfPersonToSimpleLoggerWithLambdaSyntax() {
        Consumer<Person> consumePerson = logWithConsumer();
        consumePerson.accept(p1);
        assertTrue(SimpleLogger.isLogged(p1.toString()));
    }

    @Test
    public void shouldLogToStringOfPersonToSimpleLoggersWithMethodReferenceSyntax() {
        Consumer<Person> consumePerson = logWithMethodReference();
        consumePerson.accept(p1);
        assertTrue(SimpleLogger.isLogged(p1.toString()));
    }

    @Test
    public void shouldSortPersonByName() {
        Persons sorted = persons.sort(sortByName());
        assertEquals(new Persons(p2, p1, p3), sorted);
    }

    @Test
    public void shouldReturnNameOfPersonWithLambda() {
        Supplier<String> supplier = nameOfPersonWithLambdaSupplier(p1);
        assertEquals(p1.getName(), supplier.get());
    }

    @Test
    public void shouldReturnNameOfPersonWithMethodReference() {
        Supplier<String> supplier = nameOfPersonWithMethodReferenceSupplier(p1);
        assertEquals(p1.getName(), supplier.get());
    }

}