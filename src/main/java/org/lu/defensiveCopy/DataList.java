package org.lu.defensiveCopy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataList {
	private final List<Integer> values = new ArrayList<>();

	public List<Integer> getValues() {
		return Collections.unmodifiableList(values);
	}

	public void addValue(final int value) throws IllegalArgumentException {
		if (value < 0) {
			throw new IllegalArgumentException("The value must be positive");
		}

		values.add(value);
	}

	@Override
	public String toString() {
		return String.valueOf(values);
	}

	public static void main(final String[] args) {
		final DataList data = new DataList();
		data.addValue(5);

		final List<Integer> values = data.getValues();

		System.out.println(values);
		// values.set(0, -10);
		data.addValue(15);

		System.out.println(values);
	}
}
