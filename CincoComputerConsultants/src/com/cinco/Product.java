/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the product files data
 */

package com.cinco;

public abstract class Product {

	protected String productUuid;
	protected String name;

	public Product(String productUuid, String name) {
		this.productUuid = productUuid;
		this.name = name;
	}

	public String getProductUuid() {
		return productUuid;
	}

	public String getName() {
		return name;
	}

	// abstract classes for subclasses
	public abstract String getType();

	public abstract double getTaxRate();

	public abstract double getServiceFee();

	public abstract double getProductCost();
	
	public abstract String getUnitString();
	
	public abstract String getPerUnit();

}
