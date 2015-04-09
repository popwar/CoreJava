package org.lu.designpattern.builder;

/**
 * abstract builder
 * 
 * @author Rongwei
 *
 */
public interface HouseBuilder {

	public void setName();

	public void buildBasement();

	public void buildStructure();

	public void bulidRoof();

	public void buildInterior();

	public HousePlan getHouse();
}
