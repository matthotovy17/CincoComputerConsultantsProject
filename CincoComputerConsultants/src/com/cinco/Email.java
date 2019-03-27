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
@Table(name = "Email")
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emailUuid", nullable = false)
	private Integer emailUuid;

	@Column(name = "email")
	private String email;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "personKey", nullable = false)
	private Person person;
	
	public Email(Integer emailUuid, String email, Person person) {
		super();
		this.emailUuid = emailUuid;
		this.email = email;
		this.person = person;
	}

	public Integer getEmailUuid() {
		return emailUuid;
	}

	public String getEmail() {
		return email;
	}

	public Person getPerson() {
		return person;
	}
}
