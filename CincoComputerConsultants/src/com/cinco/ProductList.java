package com.cinco;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ProductList {

	public String productUuid;
//	public double invoiceProductData;
	public ArrayList<String> invoiceProductData;
//	public String[] invoiceProductData;

	public ProductList(String productUuid, ArrayList<String> invoiceProductData) {
		this.productUuid = productUuid;
		this.invoiceProductData = invoiceProductData;
	}
	
	public ProductList() {
		
	}

	public String getProductUuid() {
		return productUuid;
	}

	public ArrayList<String> getInvoiceProductData() {
		return invoiceProductData;
	
	}
	
	public long getDaysBetween(Date beginDate, Date endDate) {
		long difference = endDate.getTime() - beginDate.getTime();
		return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
	
	}

}
