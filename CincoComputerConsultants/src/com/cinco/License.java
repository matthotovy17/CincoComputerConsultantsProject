/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This class is a subclass of product
 */

package com.cinco;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.joda.time.DateTime;
import org.joda.time.Days;

@Entity
@DiscriminatorValue("L")
public class License extends Product {
	
	@Column(name = "annualLicenseFee")
	private double annualLicenseFee;
	
	@Column(name = "serviceFee")
	private double serviceFee;
	
	private int effectiveDays;
	private String beginDate;
	private String endDate;

	public License(String productKey, String productUuid, String name, double annualLicenseFee, double serviceFee) {
		super(productKey, productUuid, name);
		this.annualLicenseFee = annualLicenseFee;
		this.serviceFee = serviceFee;
	}
	
	//Copy Constructor
	public License(License l, int effectiveDays, String beginDate, String endDate) {
		super(l.getProductKey(), l.getProductUuid(), l.getName());
		this.annualLicenseFee = l.getAnnualLicenseFee();
		this.serviceFee = l.getServiceFee();
		this.effectiveDays = effectiveDays;
		this.beginDate = beginDate;
		this.endDate = endDate;
		
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
	
	public String getBeginDate() {
		return beginDate;
	}
	
	public String getEndDate() {
		return endDate;
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