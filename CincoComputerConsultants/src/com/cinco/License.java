/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This class is a subclass of product
 */

package com.cinco;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class License extends Product {

	private double annualLicenseFee;
	private double serviceFee;
	private int effectiveDays;
	//private String effectiveDates;

	public License(String productUuid, String name, double annualLicenseFee, double serviceFee) {
		super(productUuid, name);
		this.annualLicenseFee = annualLicenseFee;
		this.serviceFee = serviceFee;
	}
	
	//Copy Constructor
	public License(License l, int effectiveDays) {
		super(l.getProductUuid(), l.getName());
		this.annualLicenseFee = l.getAnnualLicenseFee();
		this.serviceFee = l.getServiceFee();
		this.effectiveDays = effectiveDays;
	}
	
	public License() {
		
	}

	public String getType() {
		return "License";
	}

	public double getAnnualLicenseFee() {
		return annualLicenseFee;
	}

	public double getServiceFee() {
		return serviceFee;
	}

	// Licenses have a 4.25% tax rate
	public double getTaxRate() {
		return .0425;
	}
	
	public int getEffectiveDays() {
		return effectiveDays;
	}
	
	//gets the number of days between two ISO dates.
	public int getEffectiveDays(String beginDate, String endDate) {
		DateTime beginDt = new DateTime(beginDate);
		DateTime endDt = new DateTime(endDate);
				
		return Days.daysBetween(beginDt, endDt).getDays();
	}
	
	//returns the cost for that product.
	public double getProductCost() {
		return (this.getAnnualLicenseFee() * (this.getEffectiveDays() / 365.0));
	}
	
	public String getUnitsString() {
		return "Days @";
	}
	
	public String getPerUnit() {
		return "/year";
	}

}