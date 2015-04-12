package org.lu.designpattern.strategy;

public class NormalBehaviour implements IBehaviour {

	@Override
	public int moveCommand() {
		System.out
				.println("\tNormal Behaviour: if find another robot ignore it");
		return 0;
	}

}
