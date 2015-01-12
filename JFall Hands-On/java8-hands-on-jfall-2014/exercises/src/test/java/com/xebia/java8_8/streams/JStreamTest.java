package com.xebia.java8_8.streams;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class JStreamTest {

    @Test
    //Exercise 1
    public void streamCreation() {
        JStream<Integer> integers = JStream.of(0, 1, 2, 3, 4);
        assertThat(integers.head(), is(0));
        assertThat(integers.tail().head(), is(1));
        assertThat(integers.tail().tail().head(), is(2));
        assertThat(integers.tail().tail().tail().head(), is(3));
        assertThat(integers.tail().tail().tail().tail().head(), is(4));
    }

    @Test
    public void forEach() {
        final StringJoiner joiner = new StringJoiner(",");
        JStream<String> strings = JStream.of("a", "b", "b", "a");
        strings.forEach(j -> joiner.add(j));
        assertThat(joiner.toString(), is("a,b,b,a"));
    }

    @Test(expected = IllegalStateException.class)
    public void inifiniteStream() {
        JStream<Integer> integers = JStream.start(0, n -> n + 1);
        integers.forEach(i -> {
            if (i == 100000)
                throw new IllegalStateException("Enough...");
        });
    }

    @Test
    public void take200Integers() {
        JStream<Integer> integers = JStream.start(0, n -> n + 1);
        final int[] lastInteger = new int[1];
        integers.takeWhile(n -> n < 200).forEach(n -> lastInteger[0] = n);
        assertThat(lastInteger, equalTo(new int[]{199}));

        integers = new JStream.Nil<Integer>().takeWhile(n -> n > 100);
        assertTrue(integers.isEmpty());
    }

    @Test
    public void fibonacciTest() {
        assertThat(JStream.fibonacci().takeWhile(n -> n <= 100).last(), equalTo(89));
    }

    @Test
    public void dropElements() {
        JStream<String> strings = JStream.of("a1", "a2", "a3", "a4");
        assertThat(strings.drop(2).head(), equalTo("a3"));
        assertThat(strings.drop(2).tail().head(), equalTo("a4"));
        assertTrue(strings.drop(2).tail().tail().isEmpty());
    }

    @Test
    public void zipWithSumFunction() {
        JStream<Integer> s1 = JStream.of(1, 2);
        JStream<Integer> s2 = JStream.of(3, 4);
        JStream<Integer> zipped = JStream.zip(s1, s2, (a, b) -> a + b);
        assertThat(zipped.head(), equalTo(4));
        assertThat(zipped.tail().head(), equalTo(6));
    }

}

