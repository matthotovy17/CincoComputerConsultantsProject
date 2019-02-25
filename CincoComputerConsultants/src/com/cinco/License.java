/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This class is a subclass of product
 */

package com.cinco;


public class License extends Product {

	private double annualLicenseFee;
	private double serviceFee;

	public License(String productUuid, String name, double annualLicenseFee, double serviceFee) {
		super(productUuid, name);
		this.annualLicenseFee = annualLicenseFee;
		this.serviceFee = serviceFee;
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

	public double getProductCost() {
		return this.getAnnualLicenseFee();
	}

	public String getUnitString() {
		return "days @";
	}
	
	public String getPerUnit() {
		return "/yr";
	}
}