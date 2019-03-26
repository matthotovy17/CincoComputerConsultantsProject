/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the product files data
 */

package com.cinco;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "Product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "productType", discriminatorType = DiscriminatorType.STRING)
public abstract class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "productKey", nullable = false)
	protected String productKey;
	
	@Column(name = "productUuid", nullable = false)
	protected String productUuid;
	
	@Column(name = "name", nullable = false)
	protected String name;

	public Product(String productKey, String productUuid, String name) {
		this.productKey = productKey;
		this.productUuid = productUuid;
		this.name = name;
	}
	
	public Product() {
		
	}
	
	public String getProductKey() {
		return productKey;
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
	
	public abstract String getUnitsString();
	
	public abstract String getPerUnit();

}
