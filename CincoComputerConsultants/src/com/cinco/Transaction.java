/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This class performs the operations on the invoices
 */

package com.cinco;


public class Transaction {
	
	public Transaction() {
		
	}

	// returns the sub total
	public double getSubTotal(Product pr) {
		return pr.getProductCost();
	}
	
	// returns the compliance fee
	public double getComplianceFee(Customer c) {
		return c.getComplianceFee();
	}
	
	// returns the fees
	public double getFees(Product pr) {
		return pr.getServiceFee();
	}

	// returns the taxes
	public double getTaxes(Product pr, Customer c) {
		return ((pr.getTaxRate() * c.getSalesTax()) * getSubTotal(pr));
	}

	// returns the total
	public double getTotal(Product pr, Customer c) {
		return (getTaxes(pr, c) + getSubTotal(pr));
	}

}
