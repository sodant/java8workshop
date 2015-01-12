package com.xebia.java8_7.infinite_list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public interface JStream<T> extends Iterable<T> {

    T head();

    JStream<T> tail();

    /**
     * Cons
     */
    public final class Cons<T> implements JStream<T> {

        private T head;
        private Supplier<JStream<T>> tail;
        private JStream<T> evaluated;

        public Cons(T head, Supplier<JStream<T>> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public T head() {
            return this.head;
        }

        @Override
        public JStream<T> tail() {
            if (evaluated == null) {
                this.evaluated = this.tail.get();
            }
            return evaluated;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }

    /**
     * Nil
     */
    public static final class Nil<T> implements JStream<T> {

        @Override
        public Iterator<T> iterator() {
            throw new IllegalStateException("Nil stream");
        }

        @Override
        public T head() {
            throw new IllegalStateException("Nil stream");
        }

        @Override
        public JStream<T> tail() {
            throw new IllegalStateException("Nil stream");
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }

    boolean isEmpty();

    /**
     * Create an iterator for the stream
     */
    public default Iterator<T> iterator() {
        return new Iterator<T>() {

            JStream<T> current;

            @Override
            public boolean hasNext() {
                if (current == null) {
                    current = JStream.this;
                } else {
                    current = current.tail();
                }
                return !current.isEmpty();
            }

            @Override
            public T next() {
                if (hasNext()) {
                    return current.head();
                }
                throw new NoSuchElementException("Empty");
            }
        };
    }

    public default T last() {
        if (isEmpty() || tail().isEmpty()) {
            return head();
        } else {
            return tail().last();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> JStream<T> of(T... elements) {
        //#if (TARGET=="SOLUTION")
        return createStream(0, elements);
        //#else
        //$return null;
        //#endif
    }

    @SuppressWarnings("unchecked")
    static <T> JStream<T> createStream(final int index, T... elements) {
        //#if (TARGET=="SOLUTION")
        if (index == elements.length) {
            return new Nil<T>();
        }
        return new Cons<T>(elements[index], () -> createStream(index + 1, elements));
        //#else
        //$return null;
        //#endif
    }

    default void forEach(Consumer<? super T> consumer) {
        //#if (TARGET=="SOLUTION")
        JStream<T> s = this;
        while (!s.isEmpty()) {
            consumer.accept(s.head());
            s = s.tail();
        }
        //#endif
    }

    public static <T> JStream<T> start(T begin, final UnaryOperator<T> f) {
        //#if (TARGET=="SOLUTION")
        return new Cons<T>(begin, () -> start(f.apply(begin), f));
        //#else
        //$return null;
        //#endif
    }

    public default JStream<T> takeWhile(Predicate<T> predicate) {
        //#if (TARGET=="SOLUTION")
        if (isEmpty() || !predicate.test(head())) {
            return new Nil<T>();
        } else {
            return new Cons<T>(head(), () -> tail().takeWhile(predicate));
        }
        //#else
        //$return null;
        //#endif
    }

    public static JStream<Integer> fibonacci() {
        return fibonacci(0, 1);
    }

    public static JStream<Integer> fibonacci(int a, int b) {
        //#if (TARGET=="SOLUTION")
        return new Cons<Integer>(a, () -> fibonacci(b, a + b));
        //#else
        //$return null;
        //#endif
    }

    public default JStream<T> drop(final int number) {
        //#if (TARGET=="SOLUTION")
        if (number == 0) {
            return new Cons<T>(head(), () -> tail());
        } else {
            return tail().drop(number - 1);
        }
        //#else
        //$return null;
        //#endif
    }

    public static <T> JStream<T> zip(JStream<T> a, JStream<T> b, BiFunction<T, T, T> f) {
        //#if (TARGET=="SOLUTION")
        if (a.isEmpty() || b.isEmpty()) {
            return new Nil<T>();
        } else {
            return new Cons<T>(f.apply(a.head(), b.head()), () -> zip(a.tail(), b.tail(), f));
        }
        //#else
        //$return null;
        //#endif
    }
}
