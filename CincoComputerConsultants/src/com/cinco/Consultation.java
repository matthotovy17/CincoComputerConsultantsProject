/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the consultation data
 */

package com.cinco;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Consultation extends Product {

	private Person consultantPerson; 
	
	@Column(name = "hourlyFee")
	private double hourlyFee;
	
	private int billableHours;
	

	public Consultation(String productKey, String productUuid, String name, Person consultantPerson, double hourlyFee) {
		super(productKey, productUuid, name);
		this.consultantPerson = consultantPerson;
		this.hourlyFee = hourlyFee;
	}
	
	// Copy Constructor
	public Consultation(Consultation c, int billableHours) {
		super(c.getProductKey(), c.getProductUuid(), c.getName());
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

	// Returns the tax rate for a Consultation.
	public double getTaxRate() {
		return .0425;
	}

	// Returns the service fee for a Consultation.
	public double getServiceFee() {
		return 150.00;
	}

	//Returns the cost for that product.
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
