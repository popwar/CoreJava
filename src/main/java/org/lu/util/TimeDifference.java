package org.lu.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class TimeDifference {

	public static void getTimeDifference(String zone1, int year, int month,
			int day, int hourOfDay, int minute, String zone2) {
		DateTimeZone timeZone1 = DateTimeZone.forID(zone1);
		DateTime dt = new DateTime(year, month, day, hourOfDay, minute,
				timeZone1);
		System.out.println(dt);
		DateTimeZone timeZone2 = DateTimeZone.forID(zone2);
		System.out.println(dt.toMutableDateTime(timeZone2));
	}

	public static enum TimeZoneContent {
		EUROPE("Europe/London"), AUSTRLIA("Australia/Melbourne");

		private String zone;

		private TimeZoneContent(String zone) {
			this.zone = zone;
		}

		public String getZone() {
			return zone;
		}
	}

}
