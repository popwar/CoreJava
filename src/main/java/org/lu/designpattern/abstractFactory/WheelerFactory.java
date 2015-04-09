package org.lu.designpattern.abstractFactory;

public class WheelerFactory extends AbstractFactory<Wheeler> {

	@Override
	public Wheeler createObject(Wheeler wheeler) {
		Wheeler returnWheeler = null;
		try {
			returnWheeler = wheeler.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return returnWheeler;
	}
}
