package org.lu.designpattern.builder;

public class Flat implements HousePlan {

	private String name;
	private String basement;
	private String structure;
	private String roof;
	private String interior;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBasement(String basement) {
		this.basement = basement;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public void setRoof(String roof) {
		this.roof = roof;
	}

	public void setInterior(String interior) {
		this.interior = interior;
	}

}
