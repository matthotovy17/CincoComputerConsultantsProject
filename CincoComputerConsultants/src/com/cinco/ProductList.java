/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This class puts all the product data into a list
 */

package com.cinco;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ProductList {
	
	//We will not longer need to use this class since we are using the copy constructors in each product.

	public Product product;
	public ArrayList<String> invoiceProductData;

	public ProductList(Product product, ArrayList<String> invoiceProductData) {
		this.product = product;
		this.invoiceProductData = invoiceProductData;
	}
	
	public ProductList() {
		
	}

	public Product getProduct() {
		return product;
	}

	public ArrayList<String> getInvoiceProductData() {
		return invoiceProductData;
	
	}
	
	//We should not need this function anymore because it is in the License Object.
	
//	public long getDaysBetween(Date beginDate, Date endDate) {
//		long difference = endDate.getTime() - beginDate.getTime();
//		return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
//	
//	}

}
