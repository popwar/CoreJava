package org.lu.designpattern.builder;

/**
 * building manager
 * 
 * @author Rongwei
 *
 */
public class CivilEngineer {
	private HouseBuilder houseBuilder;

	public CivilEngineer(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
		this.houseBuilder.setName();
		this.houseBuilder.buildBasement();
		this.houseBuilder.buildStructure();
		this.houseBuilder.bulidRoof();
		this.houseBuilder.buildInterior();
	}

	public HousePlan getHouse() {
		return this.houseBuilder.getHouse();
	}
}
