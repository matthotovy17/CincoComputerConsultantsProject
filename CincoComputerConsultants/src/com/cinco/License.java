package com.cinco;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class License extends Product {

	private double annualLicenseFee;
	private double serviceFee;
	private int effectiveDays;

	public License(String productUuid, String name, double annualLicenseFee, double serviceFee, int effectiveDays) {
		super(productUuid, name); 
		this.annualLicenseFee = annualLicenseFee;
		this.serviceFee = serviceFee;
		this.effectiveDays = effectiveDays;
	}
	
	//Copy constructor
	public License(License l) {
		super(l.getProductUuid(), l.getName());
		annualLicenseFee = l.annualLicenseFee;
		serviceFee = l.serviceFee;
		effectiveDays = l.effectiveDays;
	}
	
	//Copy constructor that changes the number of effective days.
	public License(License l, int effectiveDays) {
		super(l.getProductUuid(), l.getName());
		annualLicenseFee = l.annualLicenseFee;
		serviceFee = l.serviceFee;
		this.effectiveDays = effectiveDays;
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
