package com.cinco;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class InvoiceReport {

	public static void main(String[] args) {
 		
		Map<String, Person> personMap = FileReader.getPersonsData("data/Persons.dat");
		Map<String, Customer> customerMap = FileReader.getCustomersData("data/Customers.dat", personMap);
		Map<String, Product> productMap = FileReader.getProductsData("data/Products.dat", personMap);
		Map<String, Invoice> invoiceMap = FileReader.getInvoiceData("data/Invoices.dat");
		
		for(Map.Entry<String, Invoice> entry : invoiceMap.entrySet()) {
			String key = entry.getKey();
			Invoice inv = invoiceMap.get(key);
			Customer c = customerMap.get(inv.getCustomerUuid());
//			String customerType = c.getType();
//			if(customerType.matches("Government") == true) {
//				
//			}

			String productList[] = inv.getProductList();
			int numUnits, effectiveDays, billableHours;
			for(String s : productList) {
				String product[] = s.split(":");
				Product p = productMap.get(product[0]);
			}	
		}
		
		public int getEffectiveDays(LocalDate beginDate, LocalDate endDate) {
			return (int) ChronoUnit.DAYS.between(beginDate, endDate);
			// Eventually we will have to account for a leap year in the mix.
			//TODO: this code needs to be moved to our product data class/object not here

		}
	}

	// TODO: Just a thought for when I am using this class in the invoice report we
	// are able to use its methods by doing
	// Transaction t = new Transaction();
	//
	// double total = t.getTotal();
	//
	// by using this we should be able to just call this method and maybe give it
	// the specific customer, Product, and invoice
	// object to be able to return the total and from there we are able to get the
	// total for that product.

}
