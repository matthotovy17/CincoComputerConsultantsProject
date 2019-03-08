/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the consultation data
 */

package com.cinco;

public class Consultation extends Product {

	private Person consultantPerson; 
	private double hourlyFee;
	private int billableHours;
	

	public Consultation(String productUuid, String name, Person consultantPerson, double hourlyFee) {
		super(productUuid, name);
		this.consultantPerson = consultantPerson;
		this.hourlyFee = hourlyFee;
	}
	
	// Copy Constructor
	public Consultation(Consultation c, int billableHours) {
		super(c.getProductUuid(), c.getName());
		this.consultantPerson = c.getConsultantPerson();
		this.hourlyFee = c.getHourlyFee();
		this.billableHours = billableHours;
	}
	
	public int getBillableHours() {
		return billableHours;
	}

	public String getType() {
		return "Consultation";
	}

	public Person getConsultantPerson() {
		return consultantPerson;
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

	//returns the cost for that product.
	public double getProductCost() {
		return (this.getHourlyFee() * this.getBillableHours());
	}
	
	public String getUnitsString() {
		return "Hours @";
	}
	
	public String getPerUnit() {
		return "/hour";
	}

}
