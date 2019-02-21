/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the invoice files data
 */

package com.cinco;

public abstract class Invoice extends Transaction implements Billable {
	
	private String invoiceUuid;
	private String customerUuid;
	private String personUuid;
	private String[] productList;
	
	public Invoice(String invoiceUuid, String customerUuid, String personUuid, String[] productList) {
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

	public String[] getProductList() {
		return productList;
	}
	
//	public abstract double getTotal();
//	public abstract double getSubTotal();
//	public abstract double getSumTaxes(); Once again not sure where to implement these methods.
//	public abstract double getSumFees();
//	
	
}
