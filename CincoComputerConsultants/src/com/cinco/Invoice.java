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
	private String customerUuid;
	private String personUuid;
	private ArrayList<ProductList> productList;

	public Invoice(String invoiceUuid, String customerUuid, String personUuid, ArrayList<ProductList> productList) {
		this.invoiceUuid = invoiceUuid;
		this.customerUuid = customerUuid;
		this.personUuid = personUuid;
		this.productList = productList;
	}

	public String getInvoiceUuid() {
		return invoiceUuid;
	}

	public String getCustomerUuid() {
		return customerUuid;
	}

	public String getPersonUuid() {
		return personUuid;
	}

	public ArrayList<ProductList> getProductList() {
		return productList;
	}

}
