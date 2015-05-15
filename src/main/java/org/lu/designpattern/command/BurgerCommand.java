package org.lu.designpattern.command;

public class BurgerCommand implements Command<Meal> {
	private final Cooker cooker = Cooker.getCooker(new CookBurger());

	@Override
	public Meal execute() {
		return cooker.cook();
	}
}
