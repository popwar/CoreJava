package org.lu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

public class Test1 {

	private interface Function<T> {
		T apply(T arg1, T arg2);
	}

	private static <E> E reduce(List<? extends E> list, Function<E> f, E initVal) {
		List<E> snapshot;
		synchronized (list) {
			snapshot = newArrayList(list);
		}
		E result = initVal;
		for (E e : snapshot)
			result = f.apply(result, e);
		return result;
	}

	// provided since java 7
	private static <E> ArrayList<E> newArrayList(List<? extends E> list) {
		return new ArrayList<E>(list);
	}

	public static void main(String... args) {
		List<Integer> list = Lists.newArrayList(1, 3, 5, 7, 9); 
		
		System.out.println(Test1.reduce(list, (Integer arg1, Integer arg2) -> {
			return arg1.intValue() - arg2.intValue();
		}, 2));
	}
}
