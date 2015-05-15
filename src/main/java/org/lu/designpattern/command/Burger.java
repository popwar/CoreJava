package org.lu.designpattern.command;

public class Burger implements Meal {
	private String name;

	private Burger(String name) {
		this.name = name;
	}

	public static Meal getMeal(String name) {
		return new Burger(name);
	}

	public String getName() {
		return this.name;
	}
}
