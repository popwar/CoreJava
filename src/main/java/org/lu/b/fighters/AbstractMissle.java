package org.lu.b.fighters;

//Test
public abstract class AbstractMissle implements Missle {

	protected int storageNumber = 0;
	
	protected Fighter fighter;

	protected AbstractMissle() {

	}

	protected AbstractMissle(int number, Fighter fighter) {
		this.storageNumber = number;
		this.fighter = fighter;
		fighter.addMissle(this);
	}

	protected void mountMissle() {
		mountDectector();
		mountFireArm();
	}

	public int getStorageNumber() {
		return storageNumber;
	}

	protected void decreaseStorageNumber() {
		if (storageNumber < 1) {
			throw new UnsupportedOperationException("run out of missle");
		}
		storageNumber--;
	}

	protected abstract void mountDectector();

	protected abstract void mountFireArm();
}
