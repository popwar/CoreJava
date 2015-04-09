package org.lu.designpattern.builder;

/**
 * concrete builder
 * 
 * @author Rongwei
 *
 */
public class IglooHouseBuilder implements HouseBuilder {

	private HousePlan house;

	public IglooHouseBuilder() {
		this.house = new House();
	}

	public void setName() {
		house.setName("Igloo House");
	}

	public void buildBasement() {
		house.setBasement("Ice Bars");
	}

	public void buildStructure() {
		house.setStructure("Ice Blocks");
	}

	public void buildInterior() {
		house.setInterior("Ice Carvings");
	}

	public void bulidRoof() {
		house.setRoof("Ice Dome");
	}

	public HousePlan getHouse() {
		return this.house;
	}
}
