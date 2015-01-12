package com.xebia.util;

import java.util.function.Supplier;

public class Measure {

	public static <T> Pair<T, Long> measure(Supplier<T> code) {
		long current = System.currentTimeMillis();
		T result = code.get();
		long elapsed = (System.currentTimeMillis() - current);
		System.out.printf("Time elapsed: %s ms\n", elapsed);
		return new Pair<T, Long>(result, elapsed);
	}

	public static class Pair<T1, T2> {

		private final T1 first;
		private final T2 second;

		public Pair(T1 first, T2 second) {
			super();
			this.first = first;
			this.second = second;
		}

		public T1 getFirst() {
			return first;
		}

		public T2 getSecond() {
			return second;
		}

	}
}
