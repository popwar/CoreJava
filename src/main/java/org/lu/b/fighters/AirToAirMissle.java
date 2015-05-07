package org.lu.b.fighters;

public class AirToAirMissle extends AbstractMissle {

	public AirToAirMissle() {
	}

	public AirToAirMissle(int number, Fighter fighter) {
		super(number, fighter);
	}

	@Override
	public void missleLaunch() {
		decreaseStorageNumber();
		System.out.println("fox 2 or 3, launching air to air missle");
	}

	@Override
	protected void mountDectector() {
		System.out.println("mount dectector for air to air missle");
	}

	@Override
	protected void mountFireArm() {
		System.out.println("mount fire arm part for air to air missle");
	}

}
