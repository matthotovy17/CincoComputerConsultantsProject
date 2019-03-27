package com.cinco;

import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name = "Country")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "countryKey", nullable = false)
	private String countryKey;
	
	@Column(name = "countryName")
	private String countryName;
	
	public Country(String countryKey, String countryName) {
		super();
		this.countryKey = countryKey;
		this.countryName = countryName;
	}

	public String getCountryKey() {
		return countryKey;
	}

	public String getCountryName() {
		return countryName;
	}

}
