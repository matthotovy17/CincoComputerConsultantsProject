/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This class is for reading in and parsing files
 */

package com.cinco;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReader {

	public FileReader() {
		
	}

	public static Map<String, Person> getPersonsData(String fileName) {
		/**
		 * HashMap for the persons object to create key value pairs with personUuid in
		 * order for the customer object to find the corresponding person object
		 */
		Map<String, Person> personMap = new HashMap<String, Person>();
		Scanner personFile = null;

		// Open file and set person file to scanner
		try {
			personFile = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		// Read through and parse the person data file and then put it into the object
		int numPersonFileLines = Integer.parseInt(personFile.nextLine());
		for (int i = 0; i < numPersonFileLines; i++) {
			String line = personFile.nextLine();
			if (!line.trim().isEmpty()) {
				Person p = null;
				String[] tokens = line.split(";");
				String personUuid = tokens[0];
				String[] name = tokens[1].split(",");
				String lastName = name[0];
				String firstName = name[1];
				String[] addr = tokens[2].split(",");
				Address address = new Address(addr[0], addr[1], addr[2], addr[3], addr[4]);
				ArrayList<String> email = new ArrayList<String>();
				if (tokens.length != 4) {
					email.add("");
					p = new Person(personUuid, lastName, firstName, address, email);
				} else {
					String[] emails = tokens[3].split(",");
					for (int j = 0; j < emails.length; j++) {
						email.add(emails[j]);
					}
					p = new Person(personUuid, lastName, firstName, address, email);
				}
				// Map key value pairs
				personMap.put(personUuid, p);
			}
		}
		personFile.close();
		return personMap;
	}

	public static Map<String, Customer> getCustomersData(String fileName, Map<String, Person> personMap) {
		// Read in and parse the customers file to put them into objects
		Map<String, Customer> customerMap = new HashMap<String, Customer>();
		Scanner customerFile = null;

		// Open file and set customer file to scanner
		try {
			customerFile = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		// Read through and parse the data file and then put it into the object
		int numCustomerFileLines = Integer.parseInt(customerFile.nextLine());
		for (int i = 0; i < numCustomerFileLines; i++) {
			String line = customerFile.nextLine();
			if (!line.trim().isEmpty()) {
				Customer c = null;
				String[] tokens = line.split(";");
				String customerUuid = tokens[0];
				Person primaryContact = personMap.get(tokens[2]);
				String name = tokens[3];
				String[] addr = tokens[4].split(",");
				Address address = new Address(addr[0], addr[1], addr[2], addr[3], addr[4]);
				// Read type and set parameters for corresponding customer subclass
				if (tokens[1].equals("G")) {
					c = new GovernmentCustomer(customerUuid, primaryContact, name, address);
				} else if (tokens[1].equals("C")) {
					c = new CorporateCustomer(customerUuid, primaryContact, name, address);
				}
				customerMap.put(customerUuid, c);
			}
		}
		customerFile.close();
		return customerMap;
	}

	public static Map<String, Product> getProductsData(String fileName, Map<String, Person> personMap) {
		// Read in and parse the products file to put them into objects
		Map<String, Product> productMap = new HashMap<String, Product>();
		Scanner productsFile = null;

		// Open file and set product file to scanner
		try {
			productsFile = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		// Read through and parse the data file and then put it into the object
		int numProductsFileLines = Integer.parseInt(productsFile.nextLine());
		for (int i = 0; i < numProductsFileLines; i++) {
			String line = productsFile.nextLine();
			if (!line.trim().isEmpty()) {
				Product p = null;
				String[] tokens = line.split(";");
				String productUuid = tokens[0];
				String name = tokens[2];
				double pricePerUnit, annualLicenseFee, serviceFee, hourlyFee;
				Person consultantPerson;
				// Read type and set parameters to corresponding product subclass
				if (tokens[1].equals("E")) {
					pricePerUnit = Double.parseDouble(tokens[3]);
					p = new Equipment(productUuid, name, pricePerUnit);
				} else if (tokens[1].equals("L")) {
					annualLicenseFee = Double.parseDouble(tokens[3]);
					serviceFee = Double.parseDouble(tokens[4]);
					p = new License(productUuid, name, annualLicenseFee, serviceFee);
				} else if (tokens[1].equals("C")) {
					consultantPerson = personMap.get(tokens[3]);
					hourlyFee = Double.parseDouble(tokens[4]);
					p = new Consultation(productUuid, name, consultantPerson, hourlyFee);
				}
				productMap.put(productUuid, p);
			}
		}
		productsFile.close();
		return productMap;
	}

	public static Map<String, Invoice> getInvoiceData(String fileName, Map<String, Person> personMap,
		                                              Map<String, Customer> customerMap, Map<String, Product> productMap) {
		// Read in and parse the invoice file to put them into objects
		Map<String, Invoice> invoiceMap = new HashMap<String, Invoice>();
		Scanner invoiceFile = null;
		// Open file and set invoice file to scanner
		try {
			invoiceFile = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		// Read through and parse the data file and then put it into the object
		int numInvoiceFileLines = Integer.parseInt(invoiceFile.nextLine());
		for (int i = 0; i < numInvoiceFileLines; i++) {
			String line = invoiceFile.nextLine();
			if (!line.trim().isEmpty()) {
				Invoice inv = null;
				String[] tokens = line.split(";");
				String invoiceUuid = tokens[0];
				Customer customer = customerMap.get(tokens[1]);
				Person salesPerson = personMap.get(tokens[2]);
				String[] productArray = tokens[3].split(",");
				ArrayList<Product> pl = new ArrayList<Product>();
				// parse the invoice file on the different products and data.
 				for(int j = 0; j < productArray.length; j++) {
					String[] productDataList = productArray[j].split(":");
					Product product = productMap.get(productDataList[0]);
					Product p = null;
					String type = product.getType();
					if(type.equals("Equipment")) {
						int numberOfUnits = Integer.parseInt(productDataList[1]);
						Equipment e = (Equipment) productMap.get(productDataList[0]);
						p = new Equipment(e, numberOfUnits);
					} else if(type.equals("Consultation")) {
						int billableHours = Integer.parseInt(productDataList[1]);
						Consultation c = (Consultation) productMap.get(productDataList[0]);
						p = new Consultation(c, billableHours);
					} else if(type.equals("License")) {
						License l = (License) productMap.get(productDataList[0]);
						String beginDate = productDataList[1];
						String endDate = productDataList[2];
						int effectiveDays = l.getEffectiveDays(beginDate, endDate);
						p = new License(l, effectiveDays);
					}
					pl.add(p);
				}
				inv = new Invoice(invoiceUuid, customer, salesPerson, pl);
				invoiceMap.put(invoiceUuid, inv);
			}
		}
		invoiceFile.close();
		return invoiceMap;
	}
}
