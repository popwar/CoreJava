package org.lu.designpattern.command;

public class Cooker {
	private final CookMeal cookMeal;
	
	private Cooker(CookMeal cookMeal){
		this.cookMeal = cookMeal;
	}
	
	public static Cooker getCooker(CookMeal cookMeal){
		return new Cooker(cookMeal);
	}

	public Meal cook() {
		return cookMeal.cook();
	}
}
