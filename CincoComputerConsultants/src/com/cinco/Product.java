/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the product files data
 */

package com.cinco;

import java.time.LocalDate;

public abstract class Product extends Transaction implements Billable {

	protected String productUuid;
	protected String name;

	public Product(String productUuid, String name) {
		this.productUuid = productUuid;
		this.name = name;
	}

	public String getProductUuid() {
		return productUuid;
	}

	public String getName() {
		return name;
	}

	// TODO: for the product subClasses we may want to make a generic method maybe
	// called getProductFee() that returns the
	// the cost of any fee that is called upon so for a consultation we could call
	// getProductFee and it would return
	// the price per hour fee that the consultant charges
	// TODO: I also feel like this may be a big no no since a price per hour fee is
	// different from a price per unit fee or
	// an annual license fee.

	// TODO: I think some or all of this abstract methods need to be in an interface
	// to "join" the product object with the customer or invoice object
	// TODO: Along with this we may also want some or all of these methods to be in
	// there own class since product is not responsible for taxes and totals
	public abstract String getType();

	public abstract double getTaxRate();

	public abstract double getServiceFee();

	public abstract double getProductCost();

	// TODO: as Bourke said on 2/18/19 we need to make sure that we do not have to
	// specify the specific type of product
	// this means that we need to parameterize our functions so that they can take
	// any type of product.

	// TODO: Along with that we can use method overloading to get the extra product
	// data that comes from the invoice file
	// and since we know that all of the extra product data comes with some integer
	// value ( even the license we
	// can create a method that takes two strings the begin and end date and returns
	// an integer for the number of days
	// that the license is effective for) when we do that we can say each product
	// from the invoice file comes with an
	// some integer value and from there we have less to worry about when
	// determining the type of product.

	// TODO: Since we should not need to determine the type of product when going
	// back through and finding the results for operations
	// we can make abstract methods in this class and use that to get the taxes and
	// the other operations depending on the product type
	// so since an equipment product has a 4.25% tax rate and the other types have
	// different rates of tax we can use gexTaxRAte() on any type
	// of product and without needing to find its type we can just call it and
	// return its tax rate.

}
