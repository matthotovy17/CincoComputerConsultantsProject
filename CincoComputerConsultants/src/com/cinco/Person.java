/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the person files data
 */

package com.cinco;

import java.util.ArrayList;

public class Person {

	protected String personUuid;
	protected String lastName;
	protected String firstName;
	protected Address address;
	protected ArrayList<String> email;

	public Person(String personUuid, String lastName, String firstName, Address address, ArrayList<String> email) {
		this.personUuid = personUuid;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.email = email;
	}

	public String getPersonUuid() {
		return personUuid;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getName() {
		return this.firstName + ", " + this.lastName;
	}

	public ArrayList<String> getEmail() {
		return email;
	}

	public Address getAddress() {
		return address;
	}

}
