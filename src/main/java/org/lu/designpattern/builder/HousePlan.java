package org.lu.designpattern.builder;

/**
 * abstract product
 * 
 * @author Rongwei
 *
 */
public interface HousePlan {

	public void setName(String name);

	public String getName();

	public void setBasement(String basement);

	public void setStructure(String structure);

	public void setRoof(String roof);

	public void setInterior(String interior);
}
