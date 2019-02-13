package com.cinco;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileReader {
	
	public FileReader(){}
	
	
	
	
	
	public Map<String, Person> getPersonsFile(String fileName) {
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
			Person p = null;
			String line = personFile.nextLine();
			String tokens[] = line.split(";");
			String personUuid = tokens[0];
			String name[] = tokens[1].split(",");
			String lastName = name[0];
			String firstName = name[1];
			String addr[] = tokens[2].split(",");
			Address address = new Address(addr[0], addr[1], addr[2], addr[3], addr[4]);
			if (tokens.length != 4) {
				p = new Person(personUuid, lastName, firstName, address, "");
			} else {
				String email = tokens[3];
				p = new Person(personUuid, lastName, firstName, address, email);
			}
			// Map key value pairs
			personMap.put(personUuid, p);
		}
		personFile.close();

		// Converting personMap to prettyPrinting JSON format
//		Gson gsonBuilderPerson = new GsonBuilder().setPrettyPrinting().create();
//		FileWriter personsOutputFile = null;
//		try {
//			personsOutputFile = new FileWriter("data/Persons.json");
//			personsOutputFile.write(gsonBuilderPerson.toJson(personMap));
//			personsOutputFile.close();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		// ---------> TODO: now that we are done with phase1 I don't think we need this
		// anymore

		return personMap;
	}

	
	
	public Map<String, Customer> getCustomersFile(String fileName, Map<String, Person> personMap) {
		

		// Read in and parse the customers file to put them into objects
//		List<Customer> customerList = new ArrayList<Customer>(); //-----------> TODO: switch this to a hashmap.
		Map<String, Customer> customerMap = new HashMap<String, Customer>();
		Scanner customerFile = null;

		// Open file and set customer file to scanner
		try {
			customerFile = new Scanner(new File("data/Customers.dat"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		// Read through and parse the data file and then put it into the object
		int numCustomerFileLines = Integer.parseInt(customerFile.nextLine());
		for (int i = 0; i < numCustomerFileLines; i++) {
			String line = customerFile.nextLine();
			if (!line.trim().isEmpty()) {
				Customer c = null;
				String tokens[] = line.split(";");
				String customerUuid = tokens[0];
				Person primaryContactUuid = personMap.get(tokens[2]);
				String name = tokens[3];
				String ad[] = tokens[4].split(",");
				Address address = new Address(ad[0], ad[1], ad[2], ad[3], ad[4]);
				// Read type and set parameters for corresponding customer subclass
				if (tokens[1].equals("G")) {
					c = new GovernmentCustomer(customerUuid, primaryContactUuid, name, address);
				} else if (tokens[1].equals("C")) {
					c = new CorporateCustomer(customerUuid, primaryContactUuid, name, address);
				}
//				customerList.add(c);
				customerMap.put(customerUuid, c);
			}
		}
		customerFile.close();

		// Converting customer array list to prettyPrinting JSON format
		Gson gsonBuilderCustomer = new GsonBuilder().setPrettyPrinting().create();
		FileWriter customerOutputFile = null;
		try {
			customerOutputFile = new FileWriter("data/Customers.json");
			customerOutputFile.write(gsonBuilderCustomer.toJson(customerMap));
			customerOutputFile.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return customerMap;
	}
	
	public Map<String, Product> getProductsFile(String fileName, Map<String, Person> personMap) {
		
		// Read in and parse the products file to put them into objects
//		List<Product> productList = new ArrayList<Product>();// ---------------> TODO:switch this to a hashMap
		Map<String, Product> productMap = new HashMap<String, Product>();
		Scanner productsFile = null;

		// Open file and set product file to scanner
		try {
			productsFile = new Scanner(new File("data/Products.dat"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		// Read through and parse the data file and then put it into the object
		int numProductsFileLines = Integer.parseInt(productsFile.nextLine());
		for (int i = 0; i < numProductsFileLines; i++) {
			String line = productsFile.nextLine();
			if (!line.trim().isEmpty()) {
				Product p = null;
				String tokens[] = line.split(";");
				String productUuid = tokens[0];
				String name = tokens[2];
				double pricePerUnit, annualLicenseFee, serviceFee, hourlyFee;
				Person consultantPersonUuid;
				// Read type and set parameters to corresponding product subclass
				if (tokens[1].equals("E")) {
					pricePerUnit = Double.parseDouble(tokens[3]);
					p = new Equipment(productUuid, name, pricePerUnit); // type
				} else if (tokens[1].equals("L")) {
					annualLicenseFee = Double.parseDouble(tokens[3]);
					serviceFee = Double.parseDouble(tokens[4]);
					p = new License(productUuid, name, annualLicenseFee, serviceFee); // type
				} else if (tokens[1].equals("C")) {
					consultantPersonUuid = personMap.get(tokens[3]);
					hourlyFee = Double.parseDouble(tokens[4]);
					p = new Consultation(productUuid, name, consultantPersonUuid, hourlyFee); // type
				}
//				productList.add(p);
				productMap.put(productUuid, p);
			}
		}
		productsFile.close();

		// Converting product array list to prettyPrinting JSON format
		Gson gsonBuilderProduct = new GsonBuilder().setPrettyPrinting().create();
		FileWriter productOutputFile = null;
		try {
			productOutputFile = new FileWriter("data/Products.json");
			productOutputFile.write(gsonBuilderProduct.toJson(productMap));
			productOutputFile.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return productMap;
		
	}

}