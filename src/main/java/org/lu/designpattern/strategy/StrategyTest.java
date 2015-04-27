package org.lu.designpattern.strategy;

public class StrategyTest {
	public static void main(String[] args) {

		Robot r2 = new Robot("George v.2.1");
		r2.setBehaviour(new DefensiveBehaviour());
		r2.move();

		NormalRobot.move();
	}
}
