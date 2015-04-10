package org.lu.designpattern.proxy;

public class Lion implements Animal {

	public void getSound(String sound) {
		System.out.println(sound);
	}

	@Override
	public double getWeight(int index) {
		double weight = 100 * index;
		System.out.println(weight);
		return weight;
	}

}
