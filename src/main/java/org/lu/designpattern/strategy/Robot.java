package org.lu.designpattern.strategy;

public class Robot {

	private IBehaviour behaviour;
	private String name;

	public Robot(String name) {
		this.name = name;
	}

	public void setBehaviour(IBehaviour behaviour) {
		this.behaviour = behaviour;
	}

	public IBehaviour getBehaviour() {
		return behaviour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void move() {
		System.out.println(this.name + ": Based on current position"
				+ "the behaviour object decide the next move:");
		final int command = behaviour.moveCommand();
		// ... send the command to mechanisms
		System.out.println("\tThe result returned by behaviour object "
				+ "is sent to the movement mechanisms " + " for the robot '"
				+ this.name + "'");
	}

}
