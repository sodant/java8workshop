package com.xebia.java8_4.functionalpatterns;

import static com.xebia.domain.Person.Role.PROGRAMMER;
import static com.xebia.domain.Person.Role.TESTER;
import static com.xebia.util.Measure.measure;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import com.xebia.domain.Person;
import com.xebia.util.Measure.Pair;

public class ImperativeToFunctionalLabsTest {

    private static final Person PROGRAMMER_Jack_28 = new Person("Jack", 28, true, PROGRAMMER);
    private static final Person PROGRAMMER_Duke_32 = new Person("Duke", 32, true, PROGRAMMER);
    private static final Person TESTER_Jeniffer_32 = new Person("Jeniffer", 34, false, TESTER);
    private static final Person PROGRAMMER_Erik_24 = new Person("Erik", 24, true, PROGRAMMER);

    @Test
    public void lab1ShouldFilterProgrammersSortByNameAndGroupByAgeFunctional() {
        List<Person> persons =
                Arrays.asList(PROGRAMMER_Jack_28, PROGRAMMER_Duke_32, PROGRAMMER_Erik_24, TESTER_Jeniffer_32);
        Map<Integer, List<Person>> expected = ImperativeToFunctionalLabs.Lab1.Imperative.filterAndGroupPersons(persons);
        Map<Integer, List<Person>> result = ImperativeToFunctionalLabs.Lab1.Functional.filterAndGroupPersons(persons);
        assertThat(result, equalTo(expected));
    }

    @Test
    public void lab2ShouldCalculateLongestWordInAListOfLinesFunctional() {
        List<String> lines =
                Arrays.asList("JFall rocks", "Java8 is great and incredibly fun too", "Streams make life so easy");
        int expected = ImperativeToFunctionalLabs.Lab2.Imperative.calculateLengthOfLongestWord(lines);
        int result = ImperativeToFunctionalLabs.Lab2.Functional.calculateLengthOfLongestWord(lines);
        assertThat(result, equalTo(expected));
    }

    @Test
    public void lab2ShouldCalculateLongestWordInAListOfLinesFunctionalInParallel() {
        List<String> lines = getManyLines(6000000);
        // warm-up JVM
        ImperativeToFunctionalLabs.Lab2.Functional.calculateLengthOfLongestWord(lines);
        // test
        Pair<Integer, Long> sequential =
                measure(() -> ImperativeToFunctionalLabs.Lab2.Imperative.calculateLengthOfLongestWord(lines));
        Pair<Integer, Long> parallel =
                measure(() -> ImperativeToFunctionalLabs.Lab2.Functional.calculateLengthOfLongestWordInParallel(lines));
        assertEquals(sequential.getFirst(), parallel.getFirst());
        assertTrue(sequential.getSecond() > parallel.getSecond());
    }

    private static List<String> getManyLines(int lines) {
        return IntStream.rangeClosed(0, lines)
                .mapToObj(i -> String.format("Java8 is incredibly fun and rocks %s times", i))
                .collect(Collectors.toList());
    }

}