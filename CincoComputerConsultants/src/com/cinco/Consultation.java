/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the consultation data
 */

package com.cinco;

public class Consultation extends Product {

	private Person consultantPersonCode;
	private double hourlyFee;

	public Consultation(String productUuid, String type, String name, Person consultantPersonCode, double hourlyFee) {
		super(productUuid, type, name);
		this.consultantPersonCode = consultantPersonCode;
		this.hourlyFee = hourlyFee;
	}
	
	public String getType() {
		return "Consultation";
	}

	public Person getConsultantPersonCode() {
		return consultantPersonCode;
	}

	public double getHourlyFee() {
		return hourlyFee;
	}
}
