/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the customer files data
 */

package com.cinco;

public abstract class Customer {

	protected String customerUuid;
	protected Person primaryContactUuid;
	protected String name;
	protected Address address;

	public Customer(String customerUuid, Person primaryContactUuid, String name, Address address) {
		super();
		this.customerUuid = customerUuid;
		this.primaryContactUuid = primaryContactUuid;
		this.name = name;
		this.address = address;
	}

	public String getCustomerUuid() {
		return customerUuid;
	}

	public Person getPrimaryContactUuid() {
		return primaryContactUuid;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}
	
	public abstract double getComplianceFee();
	public abstract String getType();
	public abstract double getTaxRate();
}
