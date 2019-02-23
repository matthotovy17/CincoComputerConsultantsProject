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
		ArrayList<String> productData = new ArrayList<String>();
		productData = pl.getInvoiceProductData();
		if(productData.size() == 1) {
			return (double)(pr.getProductCost() * (Double.parseDouble(productData.get(0))));
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d");
			Date beginDate = null;
			Date endDate = null;
		    try {
		    	beginDate = format.parse(productData.get(0));
				endDate = format.parse(productData.get(1));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		    double numDays = (double)pl.getDaysBetween(beginDate, endDate);
		    double numYears = numDays/365.0;
		    return (numYears * pr.getProductCost());
		}
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
