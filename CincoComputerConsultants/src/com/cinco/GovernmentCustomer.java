/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the government customer data from the customer files data
 */

package com.cinco;

public class GovernmentCustomer extends Customer {

	public GovernmentCustomer(String customerUuid, Person primaryContactUuid, String name,
			Address address) {
		super(customerUuid, primaryContactUuid, name, address);
	}
	
	public String getType() {
		return "Government";
	}

	public double getComplianceFee() {
		return 125.00;
	}
}
