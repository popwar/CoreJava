package org.lu.designpattern.strategy;

public class DefensiveBehaviour implements IBehaviour {

	@Override
	public int moveCommand() {
		System.out
				.println("\tDefensive Behaviour: if find another robot run from it");
		return -1;
	}
}
