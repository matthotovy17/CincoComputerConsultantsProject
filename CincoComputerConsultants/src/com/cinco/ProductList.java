/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This class puts all the product data into a list
 */

package com.cinco;

import java.util.ArrayList;

public class ProductList {
	
	//We will not longer need to use this class since we are using the copy constructors in each product.

	private Product product;
	private ArrayList<String> invoiceProductData;

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

}
