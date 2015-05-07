package org.lu.b.fighters;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class JetFighter implements Fighter {
	private final List<Missle> missleList = Lists.newCopyOnWriteArrayList();

	private final List<Missle> readOnlyMissleList = Collections
			.unmodifiableList(missleList);

	public List<Missle> getMissleList() {
		return readOnlyMissleList;
	}

	@Override
	public void addMissle(Missle missle) {
		missleList.add(missle);
	}

	public void fireMissle(Missle missle) {
		if (missle.getStorageNumber() < 1) {
			throw new UnsupportedOperationException("run out of missle");
		}
		missle.missleLaunch();
		if (missle.getStorageNumber() == 0) {
			removeMissle(missle);
		}
	}

	public void fireAllMissle() {

		readOnlyMissleList.stream().forEach(missle -> {
			for (int i = missle.getStorageNumber(); i > 0; i--) {
				fireMissle(missle);
			}
		});
	}

	private void removeMissle(Missle missle) {
		boolean complete = missleList.remove(missle);
		if (!complete) {
			throw new RuntimeException("launch failed");
		}
	}

	public static void main(String[] s) {
		Fighter f = new JetFighter();

		Missle missle1 = new AirToAirMissle(2, f);
		Missle missle2 = new AirToGroundMissle(3, f);

		f.fireAllMissle();
	}
}
