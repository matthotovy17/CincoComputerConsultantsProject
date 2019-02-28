package com.cinco;

import java.util.ArrayList;
import java.util.Map;

public class InvoiceReport {

	// TODO:1. check for rounding in our operations-- This is finished at least for now
	// 2. Check for leap years being a problem
	// 3. Check for time zones being the same and if not set them to both be the
	// same
	// 4. Finish the Detailed individual report
	// 5. Sort by Customer
	// 5. Clean up and format code.
	// 6. add in headers and comments
	// 7. Hope and pray we did good!

	public static void main(String[] args) {

		Map<String, Person> personMap = FileReader.getPersonsData("data/Persons.dat");
		Map<String, Customer> customerMap = FileReader.getCustomersData("data/Customers.dat", personMap);
		Map<String, Product> productMap = FileReader.getProductsData("data/Products.dat", personMap);
		Map<String, Invoice> invoiceMap = FileReader.getInvoiceData("data/Invoices.dat");

		printSummaryReport(personMap, customerMap, productMap, invoiceMap);
		printDetailedReport(personMap, customerMap, productMap, invoiceMap);
	}

	public static void printSummaryReport(Map<String, Person> personMap, Map<String, Customer> customerMap,
			Map<String, Product> productMap, Map<String, Invoice> invoiceMap) {

		System.out.println("Executive Summary Report \n=========================");
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("%-8s %-30s %-30s %-16s %-16s %-16s %-16s\n", "Invoice", "Customer", "SalesPerson",
				"Subtotal", "Fees", "Taxes", "Total"));

		double sumSubTotal = 0.00, sumFees = 0.00, sumTaxes = 0.00, sumTotal = 0.00, sumComplianceFee = 0.0;
		Invoice inv;
		Customer c;
		Person p;

		for (Map.Entry<String, Invoice> entry : invoiceMap.entrySet()) {
			String key = entry.getKey();
			inv = invoiceMap.get(key);
			c = customerMap.get(inv.getCustomerUuid());
			p = personMap.get(inv.getPersonUuid());
			double subTotal = 0.00, serviceFees = 0.00, taxes = 0.00, total = 0.00, complianceFee = 0.00;
			for (ProductList pl : inv.getProductList()) {
				Product pr = productMap.get(pl.getProductUuid());
				Transaction t = new Transaction();
				subTotal += t.getSubTotal(pr, pl);
				complianceFee = t.getComplianceFee(c);
				serviceFees += t.getFees(pr);
				taxes += t.getTaxes(pr, c, pl);
				total += t.getTotal(pr, c, pl);
			}
			sumComplianceFee += complianceFee;
			sumSubTotal += subTotal;
			sumFees += serviceFees + complianceFee;
			sumTaxes += taxes;
			sumTotal += total;

			subTotal = Math.round(subTotal * 100.00) / 100.00;
			serviceFees = Math.round(serviceFees * 100.00) / 100.00;
			taxes = Math.round(taxes * 100.00) / 100.00;
			total = Math.round(total * 100.00) / 100.00;
			sb.append(String.format("%-8s %-30s %-30s $%-15.2f $%-15.2f $%-15.2f $%-15.2f\n", inv.getInvoiceUuid(),
					c.getName(), p.getName(), subTotal, serviceFees + complianceFee, taxes, total + complianceFee));
		}

		sb.append("===================================================================="
				+ "=====================================================================\n");
		sumComplianceFee = Math.round(sumComplianceFee * 100.00) / 100.00;
		sumSubTotal = Math.round(sumSubTotal * 100.00) / 100.00;
		sumFees = Math.round(sumFees * 100.00) / 100.00;
		sumTaxes = Math.round(sumTaxes * 100.00) / 100.00;
		sumTotal = Math.round(sumTotal * 100.00) / 100.00;
		sb.append(String.format("%-70s $%-15.2f $%-15.2f $%-15.2f $%-15.2f\n", "TOTALS", sumSubTotal, sumFees, sumTaxes,
				sumTotal + sumComplianceFee));
		System.out.println(sb);

	}

	public static void printDetailedReport(Map<String, Person> personMap, Map<String, Customer> customerMap,
			Map<String, Product> productMap, Map<String, Invoice> invoiceMap) {
		System.out.println("Individual Invoice Detail Reports \n=================================");

		Person primaryContact;
//		Product pr;
		Invoice inv;
		Customer c;
		Person p;
		Address address;
		
		for (Map.Entry<String, Invoice> entry : invoiceMap.entrySet()) {
			String key = entry.getKey();
			inv = invoiceMap.get(key);
			c = customerMap.get(inv.getCustomerUuid());
			primaryContact = c.getPrimaryContactUuid();
			address = c.getAddress();
			p = personMap.get(inv.getPersonUuid());
			System.out.println("Invoice " + inv.getInvoiceUuid());
			System.out.println("=================");
			System.out.println("Salesperson: " + p.getName());
			System.out.println("Customer Info:");
			System.out.printf("  %s (%s)\n", c.getName(), c.getCustomerUuid());
			System.out.printf("  %s\n", primaryContact.getName());
			System.out.printf("  %s\n  %s %s %s %s\n", address.getStreet(), address.getCity(), address.getState(),
					address.getZip(), address.getCountry());
			System.out.println("----------------------------------------");
			System.out.printf("%-10s %-50s %-11s %-16s\n", "Code", "Item", "Fees", "Total");
			double subTotal = 0.00, serviceFees = 0.00, taxes = 0.00, total = 0.00, complianceFee = 0.00;
			for (ProductList pl : inv.getProductList()) {
				Product pr = productMap.get(pl.getProductUuid());
				Transaction t = new Transaction();
				subTotal += t.getSubTotal(pr, pl);
				complianceFee = t.getComplianceFee(c);
				serviceFees = t.getFees(pr);
				taxes = t.getTaxes(pr, c, pl);
				total = t.getTotal(pr, c, pl);
				ArrayList<String> data = new ArrayList<String>();
				data = pl.getInvoiceProductData();
				double numProducts = 0.0;
				String unitString = pr.getUnitsString();
				String perUnit = pr.getPerUnit();
				if(data.size() == 1) {
					numProducts = Double.parseDouble(data.get(0));
					System.out.printf("(%d %s $%f%s)", numProducts, unitString, pr.getProductCost(), perUnit);
				} else {
					String beginDate = data.get(0);
					String endDate = data.get(1);
				}
				
				System.out.printf("(%d %s $%f%s)", numProducts, unitString, pr.getProductCost(), perUnit);
				
				
				System.out.printf("%-10s %-50s $%-10.2f\n", pl.getProductUuid(), pr.getName(), pr.getServiceFee());
			}
			
			System.out.printf("\n\n");

		}

	}
}
