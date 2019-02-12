package com.cinco;

public class License extends Product {

	private double annualLicenseFee;
	private double serviceFee;

	public License(String uuid, String type, String name, double annualLicenseFee, double serviceFee) {
		super(uuid, type, name);
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
	

}
