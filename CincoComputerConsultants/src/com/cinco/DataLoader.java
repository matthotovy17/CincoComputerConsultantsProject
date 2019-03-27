package com.cinco;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataLoader {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("invoiceDataBase");

	public static List<InvoiceProduct> getInvoiceProducts() {
		EntityManager em = null;
		List<InvoiceProduct> invoiceProducts = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			String query = "FROM InvoiceProduct";
			invoiceProducts = (List<InvoiceProduct>) em.createQuery(query).getResultList();
		} catch(Exception e) {
			throw new RuntimeException("Error Loading the Invoice Products", e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return invoiceProducts;
	}
	
	public static List<Invoice> getInvoices() {
		EntityManager em = null;
		List<Invoice> invoices = null;
		
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
	
	public static List<Product> getProducts() {
		EntityManager em = null;
		List<Product> products = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			String query = "FROM Product";
			products = (List<Product>) em.createQuery(query).getResultList();
		} catch(Exception e) {
			throw new RuntimeException("Error Loading the Products", e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return products;
	}

	public static List<Customer> getCustomers() {
		EntityManager em = null;
		List<Customer> customers = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			String query = "FROM Customer";
			customers = (List<Customer>) em.createQuery(query).getResultList();
		} catch(Exception e) {
			throw new RuntimeException("Error Loading the Customers", e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return customers;
	}
	
	public static List<String> getEmails() {
		EntityManager em = null;
		List<String> emails = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			String query = "FROM Email";
			emails = (List<String>) em.createQuery(query).getResultList();
		} catch(Exception e) {
			throw new RuntimeException("Error Loading the Emails", e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return emails;
	}

	public static List<Person> getPersons() {
		EntityManager em = null;
		List<Person> persons = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			String query = "FROM Person";
			persons = (List<Person>) em.createQuery(query).getResultList();
		} catch(Exception e) {
			throw new RuntimeException("Error Loading the Persons", e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return persons;
	}
	
	public static List<Address> getAddress() {
		EntityManager em = null;
		List<Address> addresses = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			String query = "FROM Address";
			addresses = (List<Address>) em.createQuery(query).getResultList();
		} catch(Exception e) {
			throw new RuntimeException("Error Loading the Addresses", e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return addresses;
	}
	
	public static List<State> getStates() {
		EntityManager em = null;
		List<State> states = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			String query = "FROM State";
			states = (List<State>) em.createQuery(query).getResultList();
		} catch(Exception e) {
			throw new RuntimeException("Error Loading the States", e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return states;
	}
	
	public static List<Country> getCountries() {
		EntityManager em = null;
		List<Country> countries = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			String query = "FROM Country";
			countries = (List<Country>) em.createQuery(query).getResultList();
		} catch(Exception e) {
			throw new RuntimeException("Error Loading the Countries", e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return countries;
	}
	
	public static Invoice getInvoiceByKey(int invoiceKey) {
		EntityManager em = null;
		Invoice i = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			String query = "FROM Invoice i WHERE i.invoiceKey = :invoiceKey";
			i = (Invoice) em.createQuery(query).setParameter("invoiceKey", invoiceKey).getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException("Error loading Invoice with key = "+invoiceKey, e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return i;
	}
	
	public static Product getProductByKey(int productKey) {
		EntityManager em = null;
		Product pr = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			String query = "FROM Product pr WHERE pr.productKey = :productKey";
			pr = (Product) em.createQuery(query).setParameter("productKey", productKey).getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException("Error loading Product with key = "+productKey, e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return pr;
	}
	
	public static Person getPersonByKey(int personKey) {
		EntityManager em = null;
		Person p = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			String query = "FROM Person p WHERE p.personKey = :personKey";
			p = (Person) em.createQuery(query).setParameter("personKey", personKey).getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException("Error loading Person with key = "+personKey, e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return p;
	}
	
	public static Customer getCustomerByKey(int customerKey) {
		EntityManager em = null;
		Customer c = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			String query = "FROM Customer c WHERE c.customerKey = :customerKey";
			c = (Customer) em.createQuery(query).setParameter("customerKey", customerKey).getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException("Error loading Customer with key = "+customerKey, e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return c;
	}
	//TODO: we need to add in more methods for loading all the different data that we need for the transaction class.
	
}
