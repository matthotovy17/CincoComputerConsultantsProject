/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the government customer data from the customer files data
 */

package com.cinco;

public class GovernmentCustomer extends Customer {

	public GovernmentCustomer(String customerCode, String type, Person primaryContactUuid, String name,
			Address address) {
		super(customerCode, type, primaryContactUuid, name, address);
	}
	
	public String getType() {
		return "G";
	}

	public double getComplianceFee() {
		return 125.00;
	}
}
