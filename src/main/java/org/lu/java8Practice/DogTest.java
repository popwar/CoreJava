package org.lu.java8Practice;

public class DogTest {

	public static void main(String[] args) {
		DogTest.barn((String s) -> {
			System.out.println("loud");
			return "loud";
		});
	}

	@FunctionalInterface
	private interface Dog {
		public String bark(String level);
	}

	private static void barn(Dog dog) {
		dog.bark("");
	}
}
