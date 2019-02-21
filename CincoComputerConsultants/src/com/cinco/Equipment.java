package com.cinco;

public class Equipment extends Product {

	private double pricePerUnit;

	public Equipment(String productUuid, String name, double pricePerUnit) {
		super(productUuid, name);
		this.pricePerUnit = pricePerUnit;
	}

	// copy constructor
	public Equipment(Equipment e) {
		super(e.getProductUuid(), e.getName());
		pricePerUnit = e.pricePerUnit;
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

	public double getServiceFee() {
		return 0.00;
	}

	// eventualy we will have the total cost which we will need a total cost
	// function that gets pricePerUnit * #OfUnits.

}
