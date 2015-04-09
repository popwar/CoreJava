package org.lu.designpattern.abstractFactory;

public class AbstractFactoryApp {

	/*
	 * public static void createFourWheeler(AbstractFactory factory) {
	 * FourWheeler fourWheeler = factory.createFourWheeler();
	 * fourWheeler.running(); }
	 * 
	 * public static void createTwoWheeler(AbstractFactory factory) { TwoWheeler
	 * fourWheeler = factory.createTwoWheeler(); fourWheeler.running(); }
	 */

	public static void createWheeler(AbstractFactory<Wheeler> factory,
			Wheeler wheeler) {
		Wheeler createdWheeler = factory.createObject(wheeler);
		createdWheeler.running();
	}

	public static void main(String[] args) {
		AbstractFactoryApp.createWheeler(new WheelerFactory(), new Car());
		AbstractFactoryApp
				.createWheeler(new WheelerFactory(), new Skateboard());
		AbstractFactoryApp.createWheeler(new WheelerFactory(), new Bycicle());
	}
}
