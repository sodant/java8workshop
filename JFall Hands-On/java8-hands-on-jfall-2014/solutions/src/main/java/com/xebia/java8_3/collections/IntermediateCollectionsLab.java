package com.xebia.java8_3.collections;

import static java.util.Comparator.comparingInt;
import static java.util.Spliterator.NONNULL;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.toMap;

import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.xebia.domain.Company;
import com.xebia.domain.Person;
import com.xebia.domain.Person.Role;

public class IntermediateCollectionsLab {
    

    public static List<Person> removeYoungestAndOldestChildrenFromList(List<Person> persons) {
        //#if (TARGET=="SOLUTION")
        IntSummaryStatistics stats = persons.stream().collect(Collectors.summarizingInt(p -> p.getAge()));
        persons.removeIf(p -> p.getAge() == stats.getMax() || p.getAge() == stats.getMin());
        //#endif
        return persons;
    }

    public static Map<String, List<Person>> groupByNamesOfEmployee(List<Company> companies) {
        //#if (TARGET=="SOLUTION")
        Stream<Person> persons = companies.stream().flatMap(c -> c.employees.stream());
        return persons.collect(groupingBy(p -> p.getName()));
        //#else
        //$return new java.util.HashMap<String, List<Person>>();
        //#endif
    }
    
    public static Map<String, List<Person>> groupByAdultsAndMinors(List<Person> persons) {
    	//#if (TARGET=="SOLUTION")
        return persons.stream().collect(Collectors.groupingBy(p -> p.isAdult() ? "adults" : "minors"));
        //#else
        //$return null;
        //#endif
    }

    public static Collector<Person, StringJoiner, String> personToString() {
        //#if (TARGET=="SOLUTION")
        return Collector.of(//
                () -> new StringJoiner(","), //
                (j, p) -> j.add(String.format("(%s -> %s)", p.getName(), p.isMale() ? "M" : "V")), //
                (j1, j2) -> j1.merge(j2), //
                StringJoiner::toString);
        //#else
        //$return null;
        //#endif
    }
    
    public static Role findWhichRoleIsMostPopularAcrossCompanies(List<Company> companies) {
        //#if (TARGET=="SOLUTION")
        ToIntFunction<Entry<Role, List<Person>>> toSize = (e -> e.getValue().size());

        Stream<Person> persons = companies.stream().flatMap(c -> c.employees.stream());
        return persons.collect(groupingBy(Person::getRole))//
                .entrySet().stream().sorted(comparingInt(toSize).reversed()) //
                .map(Entry::getKey).findFirst().get();
        //#else
        //$return null;
        //#endif
    }

    public static Company findCompanyWithOldestEmployee(List<Company> companies) {
        //#if (TARGET=="SOLUTION")
        Map<Company, IntSummaryStatistics> map =
                companies.stream().collect(
                        toMap(c -> c,
                                (Company c) -> c.employees.stream().collect(summarizingInt((Person p) -> p.getAge()))));
        return map.entrySet().stream().max(Map.Entry.comparingByValue(comparingInt(i -> i.getMax()))).get().getKey();
        //#else
        //$return null;
        //#endif
    }

    public static <T> Stream<T> takeWhile(Stream<T> stream, Predicate<T> predicate) {
        //#if (TARGET=="SOLUTION")
        return StreamSupport.stream(new Spliterators.AbstractSpliterator<T>(Long.MAX_VALUE, NONNULL) {
            Iterator<T> streamIterator = stream.iterator();

            @Override
            public boolean tryAdvance(Consumer<? super T> action) {
                boolean shouldContinue = streamIterator.hasNext();
                if (shouldContinue) {
                    T next = streamIterator.next();
                    shouldContinue = predicate.test(next);
                    if (shouldContinue) {
                        action.accept(next);
                    }
                }
                return shouldContinue;
            }
        }, stream.isParallel());
        //#else
        //$return stream;
        //#endif
    }

    public static <A, B, C> Stream<C> zip(Stream<? extends A> a, Stream<? extends B> b,
            BiFunction<? super A, ? super B, ? extends C> zipFunction) {
        //#if (TARGET=="SOLUTION")
        Iterator<A> itA = Spliterators.iterator(a.spliterator());
        Iterator<B> itB = Spliterators.iterator(b.spliterator());
        Iterator<C> itC = new Iterator<C>() {
            @Override
            public boolean hasNext() {
                return itA.hasNext() && itB.hasNext();
            }

            @Override
            public C next() {
                return zipFunction.apply(itA.next(), itB.next());
            }
        };

        Spliterator<C> split = Spliterators.spliteratorUnknownSize(itC, NONNULL);
        return (a.isParallel() || b.isParallel()) ? StreamSupport.stream(split, true) : StreamSupport.stream(split,
                false);
        //#else
        //$return null;
        //#endif
    }

    public static Stream<Integer> zipWithSum(Stream<Integer> s1, Stream<Integer> s2) {
        //#if (TARGET=="SOLUTION")
        return zip(s1, s2, (a, b) -> a + b);
        // or: return zip(s1, s2, Integer::sum);
        //#else
        //$return null;
        //#endif
    }
    
}
