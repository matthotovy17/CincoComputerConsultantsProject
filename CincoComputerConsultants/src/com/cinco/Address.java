/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This object is for the address pertaining to the person and customer
 */

package com.cinco;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "addressKey", nullable = false)
	private int addressKey;
	
	@Column(name = "street", nullable = false)
	private String street;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "stateKey")//This will be the foreign key to the state.
	private State state; //switched from string to hold the State object
	
	@Column(name = "zip")
	private String zip;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "countryKey", nullable = false)
	private Country country; 

	public Address(String street, String city, State state, String zip, Country country) {
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

	public State getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public Country getCountry() {
		return country;
	}
}
