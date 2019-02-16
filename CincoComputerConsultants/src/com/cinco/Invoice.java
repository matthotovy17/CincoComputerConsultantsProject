/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the invoice files data
 */

package com.cinco;

public class Invoice {
	
	private String invoiceUuid;
	private String customerUuid;
	private String personUuid;
	private String[] productUuid;
	
	public Invoice(String invoiceUuid, String customerUuid, String personUuid, String[] productUuid) {
		this.invoiceUuid = invoiceUuid;
		this.customerUuid = customerUuid;
		this.personUuid = personUuid;
		this.productUuid = productUuid;
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

	public String[] getProductUuid() {
		return productUuid;
	}
	
}
