package org.lu.java8Practice;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceTest {

	private static Map<String, BiFunction<String, Integer, Mammal>> map = new HashMap<>();

	static {
		map.put("dog", Dog::new);
		map.put("cat", Cat::new);
	}

	public static Dog getDog(String breed, Function<String, Dog> dog) {
		return dog.apply(breed);
	}

	private interface Mammal {

		String getBreed();

	}

	private static class Dog implements Mammal {
		private final String breed;

		private int weight;

		public Dog(String breed) {
			this.breed = breed;
		}

		public Dog(String breed, int weight) {
			this(breed);
			this.weight = weight;
		}

		@Override
		public String getBreed() {
			return this.breed;
		}
	}

	private static class Cat implements Mammal {
		private final String breed;

		private int weight;

		public Cat(String breed) {
			this.breed = breed;
		}

		public Cat(String breed, int weight) {
			this(breed);
			this.weight = weight;
		}

		@Override
		public String getBreed() {
			return this.breed;
		}
	}

	public static Mammal getMammal(String type, String breed, int weight) {
		return map.getOrDefault(type, Dog::new).apply(breed, weight);
	}

	public static void main(String[] args) {
		String s = "Peking";
		Dog dog = MethodReferenceTest.getDog(s, Dog::new);
		System.out.println(dog.breed);

		Mammal mammal = MethodReferenceTest.getMammal("aaa", "American", 20);
		System.out.println(mammal);
	}
}
