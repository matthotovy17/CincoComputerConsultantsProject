/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This class performs the operations on the invoices
 */

package com.cinco;

import java.util.ArrayList;


public class Transaction {
	
	public Transaction() {
		
	}

	// returns the sub total
	public double getSubTotal(Product pr, ProductList pl) {
		ArrayList<String> productData = new ArrayList<String>();
		productData = pl.getInvoiceProductData();
		if(productData.size() == 1) {
			return (double)(pr.getProductCost() * (Double.parseDouble(productData.get(0))));
		} else {
			EffectiveDays days = new EffectiveDays();
			return(((double)days.getEffectiveDays(productData, pl)) * pr.getProductCost());
		}
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
	public double getTaxes(Product pr, Customer c, ProductList pl) {
		return ((pr.getTaxRate() * c.getSalesTax()) * getSubTotal(pr, pl));
	}

	// returns the total
	public double getTotal(Product pr, Customer c, ProductList pl) {
		return (getTaxes(pr, c, pl) + getSubTotal(pr, pl));
	}

}
