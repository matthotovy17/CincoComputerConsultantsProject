/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is a subclass of product
 */

package com.cinco;

public class Equipment extends Product {

	private double pricePerUnit;

	public Equipment(String productUuid, String name, double pricePerUnit) {
		super(productUuid, name);
		this.pricePerUnit = pricePerUnit;
	}

	public String getType() {
		return "Equipment";
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public double getProductCost() {
		return this.getPricePerUnit();
	}

	// returns the tax rate for an equipment product which is 7%.
	public double getTaxRate() {
		return .07;
	}

	// equipment does not have a service fee
	public double getServiceFee() {
		return 0.00;
	}

	public String getUnitString() {
		return "units @";
	}

	public String getPerUnit() {
		return "/unit";
	}

}
