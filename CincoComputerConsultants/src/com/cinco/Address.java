/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the address pertaining to the person and customer
 */

package com.cinco;

public class Address {

	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;

	public Address(String street, String city, String state, String zip, String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}

	@Override
	public String toString() {
		return street + ", " + city + ", " + state + ", " + zip + ", " + country;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getCountry() {
		return country;
	}
}
