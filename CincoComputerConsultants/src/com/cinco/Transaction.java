package com.cinco;

public class Transaction {

	// Once again as I stated in the Customer object I am confused on where to put
	// this methods.
	public double getFees(Customer c, Product p) {
		return (p.getServiceFee() + c.getComplianceFee());
	}

	public double getSubTotal(Product p, ProductList d) { // ProductData needs to be our added method to hold extra					// product data from the invoice file
		return (d.getProductData() * p.getProductCost());
	}

	public double getTaxes(Product p, Customer c, ProductList d) {
		return ((p.getTaxRate() * c.getSalesTax()) * this.getSubTotal(p, d));
	}

	public double getTotal(Product p, Customer c, ProductList d) {
		return (this.getTaxes(p, c, d) + this.getSubTotal(p, d) + this.getFees(c, p));
	}

//	
//	public double getSumFees() {
//		
//	}

	// TODO: Just a thought for when I am using this class in the invoice report we
	// are able to use its methods by doing
	// Transaction t = new Transaction();
	//
	// double total = t.getTotal();
	//
	// by using this we should be able to just call this method and maybe give it
	// the specific customer, Product, and invoice
	// object to be able to return the total and from there we are able to get the
	// total for that product.
}
