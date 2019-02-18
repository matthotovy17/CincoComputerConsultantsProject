package com.cinco;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class License extends Product {

	private double annualLicenseFee;
	private double serviceFee;

	public License(String productUuid, String name, double annualLicenseFee, double serviceFee) {
		super(productUuid, name); 
		this.annualLicenseFee = annualLicenseFee;
		this.serviceFee = serviceFee;
	}
	
	//Copy constructor
	public License(License l) {
		super(l.getProductUuid(), l.getName());
		annualLicenseFee = l.annualLicenseFee;
		serviceFee = l.serviceFee;
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
	
	public int getEffectiveDays() {
		return effectiveDays;
	}
	
	public int getEffectiveDays(LocalDate a, LocalDate b) {
		return (int) ChronoUnit.DAYS.between(a, b);
		//Eventually we will have to account for a leap year in the mix.
		
	}
	

}
