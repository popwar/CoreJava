package org.lu.designpattern.builder;

public class BuilderSample {
	public static void main(String[] args) {
		HouseBuilder iglooBuilder = new IglooHouseBuilder();
		CivilEngineer engineer = new CivilEngineer(iglooBuilder);

		HousePlan house = engineer.getHouse();

		System.out.println("Builder constructed: " + house.getName());

		iglooBuilder = new SmallFlatBuilder();
		engineer = new CivilEngineer(iglooBuilder);

		house = engineer.getHouse();

		System.out.println("Builder constructed: " + house.getName());

	}
}
