package org.lu.b.fighters;

public class AirToGroundMissle extends AbstractMissle {

	public AirToGroundMissle() {
	}

	public AirToGroundMissle(int number, Fighter fighter) {
		super(number, fighter);
	}

	@Override
	public void missleLaunch() {
		decreaseStorageNumber();
		System.out.println("attack the ground, launching air to ground missle");
	}

	@Override
	protected void mountDectector() {
		System.out.println("mount dectector for air to ground missle");
	}

	@Override
	protected void mountFireArm() {
		System.out.println("mount fire arm part for air to ground missle");
	}

}
