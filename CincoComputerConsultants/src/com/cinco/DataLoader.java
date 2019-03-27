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
	
	public static Address getAddressByKey(int addressKey) {
		EntityManager em = null;
		Address a = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			String query = "FROM Address a WHERE a.addressKey = :addressKey";
			a = (Address) em.createQuery(query).setParameter("addressKey", addressKey).getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException("Error loading Address with key = "+addressKey, e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return a;
	}
	
	public static Country getCountryByKey(int countryKey) {
		EntityManager em = null;
		Country co = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			String query = "FROM Country co WHERE co.countryKey = :countryKey";
			co = (Country) em.createQuery(query).setParameter("countryKey", countryKey).getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException("Error loading Country with key = "+countryKey, e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return co;
	}
	
	public static State getStateByKey(int stateKey) {
		EntityManager em = null;
		State s = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			String query = "FROM State s WHERE s.stateKey = :stateKey";
			s = (State) em.createQuery(query).setParameter("stateKey", stateKey).getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException("Error loading State with key = "+stateKey, e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return s;
	}
	
	public static String getEmailByKey(int emailKey) {
		EntityManager em = null;
		String email = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			String query = "FROM Email email WHERE email.emailKey = :emailKey";
			email = (String) em.createQuery(query).setParameter("emailKey", emailKey).getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException("Error loading Email with key = "+emailKey, e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return email;
	}
	
	public static InvoiceProduct getInvoiceProductByKey(int invoiceProductKey) {
		EntityManager em = null;
		InvoiceProduct ip = null;
		
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			String query = "FROM InvoiceProduct ip WHERE ip.inovoiceProductKey = :invoiceProductKey";
			ip = (InvoiceProduct) em.createQuery(query).setParameter("invoiceProductKey", invoiceProductKey).getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException("Error loading Invoice Product with key = "+invoiceProductKey, e);
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
		return ip;
	}
	
	//TODO: we need to add in more methods for loading all the different data that we need for the transaction class.
	
}
