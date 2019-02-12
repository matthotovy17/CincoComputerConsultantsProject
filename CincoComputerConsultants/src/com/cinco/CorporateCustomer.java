/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the corporate customer data from the customer files data
 */

package com.cinco;

public class CorporateCustomer extends Customer {

	public CorporateCustomer(String customerCode, Person primaryContactUuid, String name,
			Address address) {
		super(customerCode, primaryContactUuid, name, address);
	}
	
	public String getType() {
		return "Corporate";
	}

	public double getComplianceFee() {
		return 0.00;
	}

}
