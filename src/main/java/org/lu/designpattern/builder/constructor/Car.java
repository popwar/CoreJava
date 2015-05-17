package org.lu.designpattern.builder.constructor;

import java.util.Arrays;
import java.util.List;

public class Car {

	private final List<String> wheels;
	private final String panel;

	public Car(CarBuilder builder) {
		wheels = builder.wheels;
		panel = builder.panel;
	}

	private static class CarBuilder implements AbstractBuilder<Car> {
		private final List<String> wheels = Arrays.asList(new String[4]);
		private final String panel;

		private CarBuilder(String mypanel) {
			this.panel = mypanel;
		}

		private CarBuilder buildWheels(String... wheelList) {
			for (int i = 0; i < wheelList.length; i++) {
				wheels.set(i, wheelList[i]);
			}
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}

	@Override
	public String toString() {
		return "wheels: " + wheels.get(0) + "," + wheels.get(1) + ","
				+ wheels.get(2) + "," + wheels.get(3) + ",\npanel: " + panel;
	}

	public static void main(String[] args) {
		Car car = new Car.CarBuilder("wood panel").buildWheels("one", "two",
				"three", "four").build();
		System.out.println(car);
	}
}
