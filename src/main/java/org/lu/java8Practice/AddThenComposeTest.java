package org.lu.java8Practice;

import java.util.function.Function;

public class AddThenComposeTest {
	static StringBuilder content = new StringBuilder();

	public static String addHeader(String text) {
		String s = "From Raoul, Mario and Alan: " + text;
		content.append(s);
		return s;
	}

	public static String addFooter(String text) {
		String s = text + " Kind regards";
		content.append(s);
		return s;
	}

	public static String checkSpelling(String text) {
		return text.replaceAll("labda", "lambda");
	}

	public static void main(String[] s) {
		Function<String, String> f1 = (text) -> AddThenComposeTest
				.addHeader("hello, ");
		Function<String, String> f2 = (text) -> AddThenComposeTest
				.addFooter("world");
		f1.andThen(f2).apply("c");

		System.out.println(AddThenComposeTest.content);
	}
}