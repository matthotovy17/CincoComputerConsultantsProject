package com.cinco;

import java.time.format.DateTimeFormatter;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

public class EffectiveDays {
	
	public static int getEffectiveDays(String beginDate, String endDate) {
		int effectiveDays = 0;
		String begin[] = beginDate.split("-");
		String end[] = endDate.split("-");

		int beginYear = Integer.parseInt(begin[0]);
		int beginMonth = Integer.parseInt(begin[1]);
		int beginDay = Integer.parseInt(begin[2]);
		
		int endYear = Integer.parseInt(end[0]);
		int endMonth = Integer.parseInt(end[1]);
		int endDay = Integer.parseInt(end[2]);

		DateTime dt = new DateTime();
		DateTime dtLondon = dt.DateTimeFormatter.ofPattern("M/d/yyyy HH:mm").withZone(DateTimeZone.forID("Europe/London"));
		
//		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("M/d/yyyy HH:mm").withZone(DateTimeZone.forID("Europe/Dublin"));

		return effectiveDays;
	}

}
