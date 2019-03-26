/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the person files data
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
@Table(name="Person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="personKey", nullable=false)
	private Integer personKey;
	
	@Column(name = "personUuid", nullable = false)
	protected String personUuid;
	
	@Column(name = "lastName", nullable = false)
	protected String lastName;
	
	@Column(name = "firstName", nullable = false)
	protected String firstName;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "addressKey", nullable = false)
	protected Address address;
	
	@Transient
	protected ArrayList<String> email;

	public Person(Integer personKey, String personUuid, String lastName, String firstName, Address address, ArrayList<String> email) {
		this.personKey = personKey;
		this.personUuid = personUuid;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.email = email;
	}
	
	public Person() { }
	
	public Integer getPersonKey() {
		return personKey;
	}

	public String getPersonUuid() {
		return personUuid;
	}

	public String getName() {
		return this.lastName + ", " + this.firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public ArrayList<String> getEmail() {
		return email;
	}

	public Address getAddress() {
		return address;
	}

}
