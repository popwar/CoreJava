package org.lu.designpattern.command;

public class CookBurger implements CookMeal {

	@Override
	public Meal cook() {
		return Burger.getMeal("Good Burger");
	}

}