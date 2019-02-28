package com.cinco;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {
	
	public Transaction() {
		
	}

	public double getSubTotal(Product pr, ProductList pl) {
//		return (pl.getInvoiceProductData() * pr.getProductCost());
		
		
//		ArrayList<String> productData = new ArrayList<String>();
//		productData = pl.getInvoiceProductData();
//		if(productData.size() == 1) {
//			return (double)(pr.getProductCost() * (Double.parseDouble(productData.get(0))));
//		} else {
//			EffectiveDays days = new EffectiveDays();
//		    return (days.getEffectiveDays(productData, pl) * pr.getProductCost());
//		}
	}
	
	public double getComplianceFee(Customer c) {
		return c.getComplianceFee();
	}
	
	public double getFees(Product pr) {
		return pr.getServiceFee();
	}

	public double getTaxes(Product pr, Customer c, ProductList pl) {
		return ((pr.getTaxRate() * c.getSalesTax()) * getSubTotal(pr, pl));
	}

	public double getTotal(Product pr, Customer c, ProductList pl) {
		return (getTaxes(pr, c, pl) + getSubTotal(pr, pl) + getFees(pr));
	}

}
