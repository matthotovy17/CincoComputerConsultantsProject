package com.cinco;

public class ProductList {

	public String productUuid;
	public double invoiceProductData;

	public ProductList(String productUuid, double invoiceProductData) {
		this.productUuid = productUuid;
		this.invoiceProductData = invoiceProductData;
	}
	
	public ProductList() {
		
	}

	public String getProductUuid() {
		return productUuid;
	}

	public double getInvoiceProductData() {
		return invoiceProductData;
	}

}
