package org.lu.java8Practice;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterfaceTest {

	private static <T> void testPredicate(T t, Predicate<T> p, Consumer<T> c) {
		if (p.test(t)) {
			System.out.println(t.toString());
		} else {
			c.accept(t);
		}

	}

	public static void main(String[] args) {
		Predicate<String> pp = (s) -> s.equalsIgnoreCase("hello");

		FunctionalInterfaceTest.testPredicate("hello", pp.and((ss) -> false), (
				String s) -> System.out.println(Objects.hash(Objects
				.requireNonNull("hello"))));
	}
}
