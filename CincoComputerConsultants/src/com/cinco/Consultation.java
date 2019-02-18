/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the consultation data
 */

package com.cinco;

public class Consultation extends Product {

	private Person consultantPersonUuid;
	private double hourlyFee;

	public Consultation(String productUuid, String name, Person consultantPersonUuid, double hourlyFee) { 
		super(productUuid, name);
		this.consultantPersonUuid = consultantPersonUuid;
		this.hourlyFee = hourlyFee;
	}
	
//	//copy constructor
//	public Consultation(Consultation c) {
//		super(c.getProductUuid(), c.getName());
//		consultantPersonUuid = c.consultantPersonUuid;
//		hourlyFee = c.hourlyFee;
//	}
//	
	public String getType() {
		return "Consultation";
	}

	public Person getConsultantPersonUuid() {
		return consultantPersonUuid;
	}

	public double getHourlyFee() {
		return hourlyFee;
	}
}
