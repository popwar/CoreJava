package org.lu.designpattern.command;

public class NoodleCommand implements Command<Meal> {

	private final Cooker cooker = Cooker.getCooker(new CookNoodle());

	@Override
	public Meal execute() {
		return cooker.cook();
	}

}
