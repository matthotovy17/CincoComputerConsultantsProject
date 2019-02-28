/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the consultation data
 */

package com.cinco;

public class Consultation extends Product {

	private Person consultantPersonUuid; //consultantPersonUuid should of been a string
	private double hourlyFee;

	public Consultation(String productUuid, String name, Person consultantPersonUuid, double hourlyFee) {
		super(productUuid, name);
		this.consultantPersonUuid = consultantPersonUuid;
		this.hourlyFee = hourlyFee;
	}

	public String getType() {
		return "Consultation";
	}

	public Person getConsultantPersonUuid() {
		return consultantPersonUuid;
	}

	public double getHourlyFee() {
		return hourlyFee;
	}

	public double getTaxRate() {
		return .0425;
	}

	public double getServiceFee() {
		return 150.00;
	}

	public double getProductCost() {
		return this.getHourlyFee();
	}
	
	public String getUnitsString() {
		return "Hours @";
	}
	
	public String getPerUnit() {
		return "/hour";
	}

	public String getUnitString() {
		return "hours @";
	}


}
