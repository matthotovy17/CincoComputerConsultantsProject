/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the corporate customer data from the customer files data
 */

package com.cinco;

public class CorporateCustomer extends Customer {

	public CorporateCustomer(String customerCode, String type, Person primaryContactUuid, String name,
			Address address) {
		super(customerCode, type, primaryContactUuid, name, address);
	}

	public double getComplianceFee() {
		return 0.00;
	}

}
