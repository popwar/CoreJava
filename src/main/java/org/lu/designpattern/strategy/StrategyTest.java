package org.lu.designpattern.strategy;

public class StrategyTest {
	public static void main(String[] args) {

		Robot r2 = new Robot("George v.2.1");
		Robot r3 = new Robot("R2");

		r2.setBehaviour(new DefensiveBehaviour());
		r3.setBehaviour(new NormalBehaviour());

		r2.move();
		r3.move();
	}
}
