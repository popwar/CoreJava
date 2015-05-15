package org.lu.designpattern.command;

public class CookNoodle implements CookMeal {

	@Override
	public Meal cook() {
		return Noodle.getMeal("Wumai Noodle");
	}

}
