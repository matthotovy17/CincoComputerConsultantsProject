/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This class produces reports of the data files
 */

package com.cinco;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class InvoiceReport {

	public static void main(String[] args) {

		//calls methods to read in data from flat files or .dat files
//		Map<String, Person> personMap = FileReader.getPersonsData("data/Persons.dat");
//		Map<String, Customer> customerMap = FileReader.getCustomersData("data/Customers.dat", personMap);
//		Map<String, Product> productMap = FileReader.getProductsData("data/Products.dat", personMap);
//		Map<String, Invoice> invoiceMap = FileReader.getInvoiceData("data/Invoices.dat", personMap, customerMap, productMap);
//
//		Report.printSummaryReport(invoiceMap); //personMap, customerMap, productMap,
//		Report.printDetailedReport(personMap, customerMap, productMap, invoiceMap);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InvoiceDB");
        EntityManager em = emf.createEntityManager();

		List<Person> persons = DataLoader.getPersons();
		for(Person p : persons) {
			System.out.println(p);
		}
	}
	
}
