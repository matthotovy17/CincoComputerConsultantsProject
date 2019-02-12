package com.cinco;

public class Equipment extends Product {

	private double pricePerUnit;

	public Equipment(String uuid, String type, String name, double pricePerUnit) {
		super(uuid, type, name);
		this.pricePerUnit = pricePerUnit;
	}
	
	public String getType() {
		return "Equipment";
	}

	public double getPricePerUnit() {
		return pricePerUnit; 
	}
	
	//eventualy we will have the total cost which we will need a total cost
	// function that gets pricePerUnit * #OfUnits.

}
