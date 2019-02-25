/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This class is for the effective days pertaining to the lisence
 */

package com.cinco;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;

public class EffectiveDays {

	public EffectiveDays() {

	}
	
	// returns the number of effective days
	public int getEffectiveDays(String beginDate, String endDate) {

		DateTime dt = new DateTime(beginDate);
		DateTime beginDt = dt.withZone(DateTimeZone.forID("Europe/London"));
		dt = new DateTime(endDate);
		DateTime endDt = dt.withZone(DateTimeZone.forID("Europe/London"));

		int effectiveDays = Days.daysBetween(beginDt, endDt).getDays();

		return effectiveDays;
	}

	// returns the number of effective days
	public double getEffectiveDays(ArrayList<String> productData, ProductList pl) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d");
		Date beginDate = null;
		Date endDate = null;
		try {
			beginDate = format.parse(productData.get(0));
			endDate = format.parse(productData.get(1));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double numDays = (double) pl.getDaysBetween(beginDate, endDate);
		double numYears = (double) numDays / 365.0;

		return numYears;
	}
}
