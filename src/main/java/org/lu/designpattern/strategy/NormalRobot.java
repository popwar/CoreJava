package org.lu.designpattern.strategy;

public class NormalRobot {

	public static IBehaviour behaviour = getNormalBehaviour();

	private static String name = "Robot";

	private static class NormalBehaviour implements IBehaviour {

		@Override
		public int moveCommand() {
			System.out
					.println("\tNormal Behaviour: if find another robot ignore it");
			return 0;
		}

	}

	public static NormalBehaviour getNormalBehaviour() {
		return new NormalBehaviour();
	}

	@SuppressWarnings("unused")
	public static void move() {
		System.out.println(name + ": Based on current position"
				+ "the behaviour object decide the next move:");
		final int command = behaviour.moveCommand();
		// ... send the command to mechanisms
		System.out.println("\tThe result returned by behaviour object "
				+ "is sent to the movement mechanisms " + " for the robot '"
				+ name + "'");
	}
}
