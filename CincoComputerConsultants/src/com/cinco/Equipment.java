package com.cinco;

public class Equipment extends Product {

	private double pricePerUnit;

	public Equipment(String productUuid, String name, double pricePerUnit) { 
		super(productUuid, name);
		this.pricePerUnit = pricePerUnit;
	}
	
//	//copy constructor
//	public Equipment(Equipment e) {
//		super(e.getProductUuid(), e.getName());
//		pricePerUnit = e.pricePerUnit;
//	}
	
	public String getType() {
		return "Equipment";
	}

	public double getPricePerUnit() {
		return pricePerUnit; 
	}
	
	//eventualy we will have the total cost which we will need a total cost
	// function that gets pricePerUnit * #OfUnits.

}
