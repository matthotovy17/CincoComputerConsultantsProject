package com.cinco;

public interface Billable {

	double getSubTotal();

	double getTotal();

	// TODO: we need these methods to be something that we are able to use with subclasses
	// we may need to use the other transaction class to be able to use the
	// operation functions
	// but after whiteboarding everything I need to figure out all of our
	// relationships

	// TODO: the method for getSubTotal() needs to have access to the extra
	// information from the invoice object
	// as well as the products rate or cost so in saying that when we get the
	// subtotal of an equipment
	// for example we need to get the number of units from the invoice and get the
	// price per unit cost
	// from the product

	// In theory this is what it needs to look like
	public double getSubTotal() {
		return this.getProductData() * this.getProductCost();
	}
	// we still do not have perfected way of getting the extra product data from the
	// invoice but after that we
	// can finish this subTotal method with will be

	// since we are not suppose to have to know the type of type in order to get the
	// data from it
	// we should use our parameterization along with polymorphism and use our
	// billable interface
	// to connect the invoice object with the product object

	// TODO: Along with that when implementing our getTotal() method we will want to
	// connect customer type
	// along with the subtotal and the any extra fees that the customer may come
	// with

	// In theory this is what it needs to look like
	public double getTotal() {
		return this.getTaxes() + this.getSubTotal() + this.getFees();
	}
	// The taxes correspond to the customer and the subtotal should already be
	// calculated and the fees
	// come from the customer

	// TODO: Somewhere we will want to implement a getTaxes() method which does as
	// follows
	public double getTaxes() {
		return (this.getTaxRate() * this.getSalesTax()) * this.getSubTotal
	}
	// the getTaxRate method gets the tax rate from the products and the getSalesTax
	// method comes from
	// the type of customer where corporate returns 1.0 to keep the tax rate the
	// same and government
	// returns 0.00 to discard the taxes on the product there for the getTaxes
	// method returns 0 for government
	// customers but still returns the correct rate for corporate customers.

	// TODO: we will also need to implement a get Fees and maybe an added
	// getComplianceFee method
	// we will start off with adding in the getFees() method
	public double getFees() {
		return this.getServiceFee(); //here we will need to find a way to add all of the fees up, including the compliance fee
	}

}
