/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the product files data
 */

package com.cinco;

public abstract class Product {

	protected String productUuid;
//	protected String type;
	protected String name;

	public Product(String productUuid, String name) { //String type.
		super();
//		this.type = type; //since we make type an abstract method we should take this out.
		this.productUuid = productUuid;
		this.name = name;
	}

	public String getProductUuid() {
		return productUuid;
	}

	public String getName() {
		return name;
	}
	
	public abstract String getType();

}
