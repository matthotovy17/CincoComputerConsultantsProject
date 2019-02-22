package com.cinco;

public class ProductList {

	public String productUuid;
	public int invoiceProductData;

	public ProductList(String productUuid, int invoiceProductData) {
		this.productUuid = productUuid;
		this.invoiceProductData = invoiceProductData;
	}

	public String getProductUuid() {
		return productUuid;
	}

	public int getInvoiceProductData() {
		return invoiceProductData;
	}

}
