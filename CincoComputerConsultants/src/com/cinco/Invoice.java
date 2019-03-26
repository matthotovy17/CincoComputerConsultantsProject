/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the invoice files data
 */

package com.cinco;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="invoiceKey", nullable=false)
	private String invoiceKey;
	
	@Column(name="invoiceUuid", nullable=false)
	private String invoiceUuid;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="customerKey", nullable=false)
	private Customer customer;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="personKey", nullable=false)
	private Person salesPerson;
	
	@Transient
	private ArrayList<Product> productList;

	public Invoice(String invoiceKey, String invoiceUuid, Customer customer, Person salesPerson, ArrayList<Product> productList) {
		this.invoiceKey = invoiceKey;
		this.invoiceUuid = invoiceUuid;
		this.customer = customer;
		this.salesPerson = salesPerson;
		this.productList = productList;
	}
	
	public Invoice() { }
	
	public String getInvoiceKey() {
		return invoiceKey;
	}

	public String getInvoiceUuid() {
		return invoiceUuid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Person getSalesPerson() {
		return salesPerson;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

}
