/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the invoice files data
 */

package com.cinco;

import java.util.ArrayList;

public class Invoice {

	private String invoiceUuid;
	private Customer customer;
	private Person salesPerson;
	private ArrayList<Product> productList;

	public Invoice(String invoiceUuid, Customer customer, Person salesPerson, ArrayList<Product> productList) {
		this.invoiceUuid = invoiceUuid;
		this.customer = customer;
		this.salesPerson = salesPerson;
		this.productList = productList;
	}

	public String getInvoiceUuid() {
		return invoiceUuid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Person getSalesPerson() {
		return salesPerson;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

}
