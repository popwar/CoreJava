package org.lu.java8Practice;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTest {

	private static class Dish {
		private final String name;
		private final boolean vegetarian;
		private final int calories;
		private final Type type;
		private List<String> aaa = Arrays.asList("a", "b");

		public Dish(String name, boolean vegetarian, int calories, Type type) {
			this.name = name;
			this.vegetarian = vegetarian;
			this.calories = calories;
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public boolean isVegetarian() {
			return vegetarian;
		}

		public int getCalories() {
			return calories;
		}

		public Type getType() {
			return type;
		}

		public List<String> getList() {
			return aaa;
		}

		@Override
		public String toString() {
			return name + calories;
		}

		public enum Type {
			MEAT, FISH, OTHER
		}
	}

	public static List<Dish> getMenuList() {

		return Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), new Dish(
						"chicken", false, 400, Dish.Type.MEAT), new Dish(
						"french fries", true, 530, Dish.Type.OTHER), new Dish(
						"rice", true, 350, Dish.Type.OTHER), new Dish(
						"season fruit", true, 120, Dish.Type.OTHER), new Dish(
						"pizza", true, 550, Dish.Type.OTHER), new Dish(
						"prawns", false, 300, Dish.Type.FISH), new Dish(
						"salmon", false, 450, Dish.Type.FISH));
	}

	public static void main(String[] s) {
		Dish d = new Dish("beef", false, 700, Dish.Type.MEAT);
		List<String> list = d.getList();
		list.set(0, "aaa");
		d.getList().forEach((String ss) -> System.out.println(ss));

		Set<String> dishSet = StreamTest.getMenuList().stream()
				.filter(dish -> dish.getType().equals(Dish.Type.FISH))
				.map(Dish::getName).collect(Collectors.toSet());
		System.out.println(dishSet);
	}
}
