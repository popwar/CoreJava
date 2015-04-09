package org.lu.designpattern.builder;

public class SmallFlatBuilder implements HouseBuilder {
	private HousePlan house;

	public SmallFlatBuilder() {
		this.house = new Flat();
	}

	@Override
	public void setName() {
		house.setName("small flat");
	}

	@Override
	public void buildBasement() {
		house.setBasement("no basement");
	}

	@Override
	public void buildStructure() {
		house.setBasement("");
	}

	@Override
	public void bulidRoof() {
		house.setRoof("");
	}

	@Override
	public void buildInterior() {
		house.setInterior("");
	}

	@Override
	public HousePlan getHouse() {
		return this.house;
	}

}
