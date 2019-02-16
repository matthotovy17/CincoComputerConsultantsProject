package com.cinco;

import java.util.Map;

public class InvoiceReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. in here when finding the start and end date of a license we need to use
		// the java.time libaray and use the localDate method to find year-month-day
		
		//2. Make copy constructors for changing values in objects and subclasses
		
//		INV003;ttew;321f;900g:25,1449:3,1p94:2018-05-12:2019-05-13
		
		//invoiceUuid;customerUuid
		
		//3. follow the single responsiblilty principle 
		// create classes for loading data, serializing data, 
		
		Map<String, Person> personMap = FileReader.getPersonsData("data/Persons.dat");
		Map<String, Customer> customerMap = FileReader.getCustomersData("data/Customers.dat", personMap);
		Map<String, Product> productMap = FileReader.getProductsData("data/Products.dat", personMap);
		Map<String, Invoice> invoiceMap = FileReader.getInvoiceData("data/Invoices.dat");
		
		for(Map.Entry<String, Invoice> entry : invoiceMap.entrySet()) {
			String key = entry.getKey();
			
		}

	}

}
