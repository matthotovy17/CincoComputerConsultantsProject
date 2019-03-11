package com.cinco;

import java.util.Map;

public class Report {

	// this method takes an invoiceMap and prints the executive summary report to the standard output.
	public static void printSummaryReport(Map<String, Invoice> invoiceMap) {
		// Map<String, Person> personMap, Map<String, Customer> customerMa, Map<String,
		// Product> productMap

		System.out.println("Executive Summary Report \n=========================");
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("%-8s %-30s %-30s %-16s %-16s %-16s %-16s \n", "Invoice", "Customer", "SalesPerson",
				"Subtotal", "Fees", "Taxes", "Total"));

		double sumSubTotal = 0.00, sumFees = 0.00, sumTaxes = 0.00, sumTotal = 0.00, sumComplianceFee = 0.0;
		Invoice inv;
		Customer c;
		Person p;

		// reads through each invoice instance
		for (Map.Entry<String, Invoice> entry : invoiceMap.entrySet()) {
			String key = entry.getKey();
			inv = invoiceMap.get(key);
			c = inv.getCustomer();
			p = inv.getSalesPerson();
			double subTotal = 0.00, serviceFees = 0.00, taxes = 0.00, total = 0.00, complianceFee = 0.00;
			// reads through the product list from the invoice
			for (Product pr : inv.getProductList()) {
				Transaction t = new Transaction();
				subTotal += t.getSubTotal(pr);
				complianceFee = t.getComplianceFee(c);
				serviceFees += t.getFees(pr);
				taxes += t.getTaxes(pr, c);
				total += t.getTotal(pr, c);
			}
			sumComplianceFee += complianceFee;
			sumSubTotal += subTotal;
			sumFees += serviceFees;
			sumTaxes += taxes;
			sumTotal += total;

			// print formatting
			subTotal = Math.round(subTotal * 100.00) / 100.00;
			serviceFees = Math.round(serviceFees * 100.00) / 100.00;
			taxes = Math.round(taxes * 100.00) / 100.00;
			total = Math.round(total * 100.00) / 100.00 + serviceFees;
			sb.append(String.format("%-8s %-30s %-30s $%-15.2f $%-15.2f $%-15.2f $%-15.2f\n", inv.getInvoiceUuid(),
					c.getName(), p.getName(), subTotal, serviceFees, taxes, total + complianceFee));
		}

		sb.append("===================================================================="
				+ "=====================================================================\n");
		sumComplianceFee = Math.round(sumComplianceFee * 100.00) / 100.00;
		sumSubTotal = Math.round(sumSubTotal * 100.00) / 100.00;
		sumFees = Math.round(sumFees * 100.00) / 100.00;
		sumTaxes = Math.round(sumTaxes * 100.00) / 100.00;
		sumTotal = Math.round(sumTotal * 100.00) / 100.00;
		sb.append(String.format("%-70s $%-15.2f $%-15.2f $%-15.2f $%-15.2f\n", "TOTALS", sumSubTotal,
				sumFees + sumComplianceFee, sumTaxes, sumTotal + sumFees));
		System.out.println(sb);

	}


	// This method takes ... and prints the detailed summary report of each invoice
	// and prints it to the standard output
	public static void printDetailedReport(Map<String, Person> personMap, Map<String, Customer> customerMap,
			Map<String, Product> productMap, Map<String, Invoice> invoiceMap) {
		System.out.println("Individual Invoice Detail Reports \n=================================");

		Person primaryContact;
		Invoice inv;
		Customer c;
		Person p;
		Address address;

		// reads through each invoice instance
		for (Map.Entry<String, Invoice> entry : invoiceMap.entrySet()) {
			double sumSubTotal = 0.00, sumFees = 0.00, sumTaxes = 0.00, sumTotal = 0.00, sumComplianceFee = 0.0;
			String key = entry.getKey();
			inv = invoiceMap.get(key);
			c = inv.getCustomer();
			primaryContact = c.getPrimaryContactUuid();
			address = c.getAddress();
			p = inv.getSalesPerson();
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
			double subTotal, taxes, total, complianceFee = 0.00, fees;
			// reads through the product list for the invoice
			for (Product pl : inv.getProductList()) {
				Transaction t = new Transaction();
				subTotal = t.getSubTotal(pl);
				complianceFee = t.getComplianceFee(c);
				taxes = t.getTaxes(pl, c);
			}
			// print formatting
			sumComplianceFee += complianceFee;
			sumSubTotal = Math.round(sumSubTotal * 100.00) / 100.00;
			System.out
					.println("====================================                          =========================");
			System.out.printf("%-61s $%-10.2f $%-10.2f\n", "SUB-TOTALS", (sumFees + sumComplianceFee), sumSubTotal);
			System.out.printf("%-73s $%-10.2f\n", "COMPLIANCE FEE", sumComplianceFee);
			System.out.printf("%-73s $%-10.2f\n", "TAXES", sumTaxes);
			System.out.printf("%-73s $%-10.2f\n", "TOTAL", (sumTotal + sumComplianceFee));
			System.out.printf("\n\n");

		}

	}

}
