package com.cinco;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class InvoiceReport {

	public static void main(String[] args) {
		
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
		
		//The only thing this enhanced for loop should do in go through the invoices call on methods for the operations
		// and after this loop we should then make a method that prints out the reports
		for(Map.Entry<String, Invoice> entry : invoiceMap.entrySet()) {
			String key = entry.getKey();
			Invoice inv = invoiceMap.get(key);
			Customer c = customerMap.get(inv.getCustomerUuid());
//			String customerType = c.getType();
//			if(customerType.matches("Government") == true) {
//				
//			}
			
			//TODO: XXXXProbably at the end need to make this its own class instead of having a nested loopXXXXX
			String productList[] = inv.getProductList();
			int numUnits, effectiveDays, billableHours;
			for(String s : productList) {
				String product[] = s.split(":");
				 //This should be its own method in some class probably
				Product p = productMap.get(product[0]);
				//TODO: All of this checking its type should not be necessary when we are finished.
				if((p.getType()).matches("Equipment") == true) {
					numUnits = Integer.parseInt(product[1]);
				} else if((p.getType()).matches("Consultation") == true) {
					billableHours = Integer.parseInt(product[1]);
				} else {
					LocalDate beginDate = LocalDate.parse(product[1]);
					LocalDate endDate = LocalDate.parse(product[2]);
					effectiveDays = (int) ChronoUnit.DAYS.between(beginDate, endDate); //TODO: take this out and use the getEffectiveDays() from license.java
				}
				
				
				if((c.getType()).matches("Government") == true && (p.getType()).matches("Equipment") == true) {
					numUnits = Integer.parseInt(product[1]);
					
				} else if() {
					
				}
//TODO: we need to do some operations for the taxes and that stuff in here I think because if we have
	 // two instances of different equipments in a single invoice than the numUnits would end up being
	 // whatever the last equipment numUnits is so that being said we still need to be able to store the data.
			}
			
			
//XXXXXXXXXXXXXX TODO: I think we need another class that or object that holds the total, sub-total, taxes, fees for each invoice

			
		}
		
		//create a method for the overall summary report and a method for the individual reports

//XXXXXXXXXXXXX maybe instead of using a copy constructor for the invoice extra piece of data on
//XXXXXXXXXXXXX we can make transaction classes for each product and given the extra piece of data
//XXXXXXXXXXX   and the map we can use the piece of data as well as store the piece of data.

	}

}
