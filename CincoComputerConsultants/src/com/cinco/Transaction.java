package com.cinco;

public class Transaction {

	public double getFees(Customer c, Product p) {
		return (p.getServiceFee() + c.getComplianceFee());
	}

	public double getSubTotal(Product p, ProductList pl) {
		return (pl.getInvoiceProductData() * p.getProductCost());
	}

	public double getTaxes(Product p, Customer c, ProductList pl) {
		return ((p.getTaxRate() * c.getSalesTax()) * this.getSubTotal(p, pl));
	}

	public double getTotal(Product p, Customer c, ProductList pl) {
		return (this.getTaxes(p, c, pl) + this.getSubTotal(p, pl) + this.getFees(c, p));
	}

}
