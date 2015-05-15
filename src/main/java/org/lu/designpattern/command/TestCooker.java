package org.lu.designpattern.command;

import java.util.List;

public class TestCooker {
	public static void main(String[] args) {
		MealInvoker<Meal> invoker = new MealInvoker<>();
		invoker.setMealCommand(new NoodleCommand());
		invoker.setMealCommand(new BurgerCommand());
		List<Meal> meal = invoker.getMeal();
		meal.stream().forEach(
				currentMeal -> System.out.println(currentMeal.getClass()));
	}
}
