package org.lu.designpattern.decorator;

import java.util.LinkedHashSet;

public class ForwardingTest {
	private static final InstrumentedSet<String> set;

	static {
		set = new InstrumentedSet<>(
				new InstrumentedSet<>(new LinkedHashSet<>()));
	}

	static InstrumentedSet<String> getForwardingTest() {
		return set;
	}

	public static void main(String[] args) {
		InstrumentedSet<String> set = ForwardingTest.getForwardingTest();
		set.add("b");
		set.add("a");
		set.add("c");
		set.stream().forEach(e -> System.out.println(e));
		set.getDesc();
	}
}
