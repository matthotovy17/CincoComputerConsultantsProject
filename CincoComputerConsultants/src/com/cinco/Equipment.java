/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is a subclass of product
 */

package com.cinco;

public class Equipment extends Product {

	private double pricePerUnit;
	private int numberOfUnits;

	public Equipment(String productUuid, String name, double pricePerUnit) {
		super(productUuid, name);
		this.pricePerUnit = pricePerUnit;
	}

	//Copy Constructor
	public Equipment(Equipment e, int numberOfUnits) {
		super(e.getProductUuid(), e.getName());
		this.pricePerUnit = e.getPricePerUnit();
		this.numberOfUnits = numberOfUnits;
	}

	public int getNumUnits() {
		return numberOfUnits;
	}

	public String getType() {
		return "Equipment";
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	//returns the cost for that product.
	public double getProductCost() {
		return (this.getPricePerUnit() * this.getNumUnits());
	}

	// returns the tax rate for an equipment product which is 7%.
	public double getTaxRate() {
		return .07;
	}

	// equipment does not have a service fee
	public double getServiceFee() {
		return 0.00;
	}

	public String getUnitsString() {
		return "units @";
	}

	public String getPerUnit() {
		return "/unit";
	}

}
