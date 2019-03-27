package com.cinco;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataLoader {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("invoiceDataBase");

	public static List<Invoice> getInvoices() {
		
		EntityManager em = null;
		List<InvoiceProduct> invoiceProducts = null;
		List<Invoice> invoices = null;
		List<Product> products = null;
		List<Customer> customers = null;
		List<String> emails = null;
		List<Person> persons = null;
		List<Address> addresses = null;
		List<State> states = null;
		List<Country> countries = null;
		
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			String query = "FROM Invoice";
			invoices = (List<Invoice>) em.createQuery(query).getResultList();
		} catch(Exception e) {
			throw new RuntimeException("Error Loading the Invoices", e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		
		return invoices;
	}
	
	//TODO: we need to add in more methods for loading all the different data that we need for the transaction class.
	
}
