/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the customer files data
 */

package com.cinco;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Customer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "customerType", discriminatorType = DiscriminatorType.STRING)
public abstract class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "customerKey")
	protected String customerKey;
	
	@Column(name = "customerUuid")
	protected String customerUuid;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "personKey", nullable = false)
	protected Person primaryContact;
	
	@Column(name = "customerName")
	protected String customerName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "addressKey", nullable = false)
	protected Address address;

	public Customer(String customerUuid, Person primaryContact, String customerName, Address address) {
		super();
		this.customerUuid = customerUuid;
		this.primaryContact = primaryContact;
		this.customerName = customerName;
		this.address = address;
	}

	public String getCustomerUuid() {
		return customerUuid;
	}

	public Person getPrimaryContactUuid() {
		return primaryContact;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Address getAddress() {
		return address;
	}

	public abstract double getComplianceFee();

	public abstract String getType();

	public abstract double getSalesTax();
}
