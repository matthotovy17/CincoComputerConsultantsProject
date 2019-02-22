package com.cinco;

public class Transaction {
	
	public Transaction() {
		
	}

	public double getSubTotal(Product pr, ProductList pl) {
		return (pl.getInvoiceProductData() * pr.getProductCost());
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
