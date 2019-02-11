package com.cinco;

public class Equipment extends Product {

	private double pricePerUnit;

	public Equipment(String uuid, String type, String name, double pricePerUnit) {
		super(uuid, type, name);
		this.pricePerUnit = pricePerUnit;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

}
