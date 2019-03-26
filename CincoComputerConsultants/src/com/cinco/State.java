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
@Table(name = "State")
public class State {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "stateKey", nullable = false)
	private String stateKey;
	
	@Column(name = "stateName")
	private String stateName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "countryKey", nullable = false)
	private Country country;
	
	public State(String stateKey, String stateName, Country country) {
		super();
		this.stateKey = stateKey;
		this.stateName = stateName;
		this.country = country;
	}

	public String getStateKey() {
		return stateKey;
	}

	public String getStateName() {
		return stateName;
	}

	public Country getCountry() {
		return country;
	}

}
