/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the corporate customer data from the customer files data
 */

package com.cinco;

public class CorporateCustomer extends Customer { //since customer implements Billable we still need to add in the methods.

	public CorporateCustomer(String customerUuid, Person primaryContactUuid, String name,
			Address address) {
		super(customerUuid, primaryContactUuid, name, address);
	}
	
	public String getType() {
		return "Corporate";
	}

	public double getComplianceFee() { //Corporate customers do not have compliance fee
		return 0.00;
	}
	
	public double getSalesTax() {
		return 1.00;
	}

}
