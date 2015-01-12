package com.xebia.java8_1.lambdas;

import static com.xebia.domain.Person.Role.PROGRAMMER;
import static com.xebia.domain.Person.Role.TESTER;
import static com.xebia.java8_1.lambdas.LambdaLabs.filterMaleAdultsWithStaticMethodReference;
import static com.xebia.java8_1.lambdas.LambdaLabs.filterUsingAnonymousInnerClass;
import static com.xebia.java8_1.lambdas.LambdaLabs.filterWithLambda;
import static com.xebia.java8_1.lambdas.LambdaLabs.filterWithMethodReference;
import static com.xebia.java8_1.lambdas.LambdaLabs.sortPersonsWithLambda;
import static com.xebia.java8_1.lambdas.LambdaLabs.sortWithComparing;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.junit.Test;

import com.xebia.domain.Person;
import com.xebia.domain.Persons;

/**
 * In this lab you will get acquainted the Lambda and Method Reference syntax.
 * Complete all tests.
 */
public class LambdaLabsTest {
    Person p1;
    Person p2;
    Person p3;
    Persons persons;

    @Before
    public void setUp() throws Exception {
        p1 = new Person("Jack", 31, true, PROGRAMMER);
        p2 = new Person("Benjamin", 12, true, PROGRAMMER);
        p3 = new Person("Suse", 37, false, TESTER);
        persons = new Persons(p1, p2, p3);
    }

    @Test
    public void shouldFilterAdultsWithAnonymousInnerClass() {
        assertThat(filterUsingAnonymousInnerClass(persons), equalTo(new Persons(p1, p3)));
    }

    @Test
    public void shouldFilterAdultsWithLambda() {
        assertThat(filterWithLambda(persons), equalTo(new Persons(p1, p3)));
    }

    @Test
    public void shouldFilterAdultsWithMethodReference() {
        assertThat(filterWithMethodReference(persons), equalTo(new Persons(p1, p3)));
    }

    @Test
    public void shouldFilterMaleAdultsWithStaticMethodReference() {
        assertThat(filterMaleAdultsWithStaticMethodReference(persons), equalTo(new Persons(p1)));
    }

    @Test
    public void shouldSortPersonByNameWithLambda() {
        assertThat(sortPersonsWithLambda(persons), equalTo(new Persons(p2, p1, p3)));
    }

    @Test
    public void shouldSortPersonByNameUsingComparatorComparingWithMethodReference() {
        assertThat(sortWithComparing(persons), equalTo(new Persons(p2, p1, p3)));
    }
}