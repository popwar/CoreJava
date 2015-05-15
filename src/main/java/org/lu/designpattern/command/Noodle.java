package org.lu.designpattern.command;

public class Noodle implements Meal {

	private String name;

	private Noodle(String name) {
		this.name = name;
	}

	public static Meal getMeal(String name) {
		return new Noodle(name);
	}

	public String getName() {
		return this.name;
	}
}
