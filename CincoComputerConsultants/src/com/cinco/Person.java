/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the person files data
 */

package com.cinco;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="personKey", nullable=false)
	private Integer personKey;
	
	@Column(name = "personUuid", nullable = false)
	private String personUuid;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "addressKey", nullable = false)
	private Address address;
	
	@OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="personId", nullable=false)
	private List<Email> emails;

	public Person(Integer personKey, String personUuid, String lastName, String firstName, Address address, List<Email> emails) {
		this.personKey = personKey;
		this.personUuid = personUuid;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.emails = emails;
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

	public List<Email> getEmails () {
		return emails;
	}

	public Address getAddress() {
		return address;
	}

}
