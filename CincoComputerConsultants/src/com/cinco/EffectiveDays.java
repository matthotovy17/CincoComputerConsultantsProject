package com.cinco;


import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;


public class EffectiveDays {
	
	public EffectiveDays() {
		
	}
	
	public int getEffectiveDays(String beginDate, String endDate) {
//		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		
		
		DateTime dt = new DateTime(beginDate);
		DateTime beginDt = dt.withZone(DateTimeZone.forID("Europe/London"));
		dt = new DateTime(endDate);
		DateTime endDt = dt.withZone(DateTimeZone.forID("Europe/London"));
		
		int effectiveDays = Days.daysBetween(beginDt, endDt).getDays();
		
//		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(DateTimeZone.forID("Europe/Dublin"));

		
		
		
		
		return effectiveDays;
	}

}
