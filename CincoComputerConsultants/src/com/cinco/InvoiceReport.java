package com.cinco;


import java.util.Map;

public class InvoiceReport {
	
	//TODO:1. check for rounding in our operations
	//     2. Check for leap years being a problem
	//     3. Check for time zones being the same and if not set them to both be the same
	//     4. Finish the Detailed individual report
	//     5. Sort by Customer
	//     5. Clean up and format code.
	//     6. add in headers and comments
	//     7. Hope and pray we did good!

	public static void main(String[] args) {

		Map<String, Person> personMap = FileReader.getPersonsData("data/Persons.dat");
		Map<String, Customer> customerMap = FileReader.getCustomersData("data/Customers.dat", personMap);
		Map<String, Product> productMap = FileReader.getProductsData("data/Products.dat", personMap);
		Map<String, Invoice> invoiceMap = FileReader.getInvoiceData("data/Invoices.dat");
		
		printSummaryReport(personMap, customerMap, productMap, invoiceMap);

	}

	public static void printSummaryReport(Map<String, Person> personMap, Map<String, Customer> customerMap,
			Map<String, Product> productMap, Map<String, Invoice> invoiceMap) {

		System.out.println("Executive Summary Report \n=========================");
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("%-8s %-30s %-30s %-16s %-16s %-16s %-16s\n", "Invoice", "Customer", "SalesPerson",
				"Subtotal", "Fees", "Taxes", "Total"));
		
		double subTotal = 0.00, fees = 0.00, taxes = 0.00, total = 0.00;
		double sumSubTotal = 0.00, sumFees = 0.00, sumTaxes = 0.00, sumTotal = 0.00;
		Invoice inv;// = null;
		Customer c;// = null;
		Person p;// = null;

		for (Map.Entry<String, Invoice> entry : invoiceMap.entrySet()) {
			String key = entry.getKey();
			inv = invoiceMap.get(key);
			c = customerMap.get(inv.getCustomerUuid());
			p = personMap.get(inv.getPersonUuid());
			for (ProductList pl : inv.getProductList()) {
				Product pr = productMap.get(pl.getProductUuid());
				Transaction t = new Transaction();
				subTotal += t.getSubTotal(pr, pl);
				fees += t.getFees(c, pr);
				taxes += t.getTaxes(pr, c, pl);
				total += t.getTotal(pr, c, pl);
			}

			sumSubTotal += subTotal;
			sumFees += fees;
			sumTaxes += taxes;
			sumTotal += total;
			
			sb.append(String.format("%-8s %-30s %-30s $%-15.2f $%-15.2f $%-15.2f $%-15.2f\n", inv.getInvoiceUuid(), c.getName(),
					p.getName(), subTotal, fees, taxes, total));
//			System.out.println(sb);

		}
		
		sb.append("===================================================================="
				+ "=====================================================================\n");
		sb.append(String.format("%-70s $%-15.2f $%-15.2f $%-15.2f $%-15.2f\n", "TOTALS", sumSubTotal, sumFees, sumTaxes, sumTotal));

		
		System.out.println(sb);

	}

//	public void printDetailedReport(Map<String, Person> personMap, Map<String, Customer> customerMap,
//			Map<String, Product> productMap, Map<String, Invoice> invoiceMap) {
//
//	}

}
