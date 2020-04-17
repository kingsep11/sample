package com.example.demo.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Contactperson {
	private String contactFirstName;
	private String contactLastName;
	public String getContactFirstName() {
		return contactFirstName;
	}
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}
	public String getContactLastName() {
		return contactLastName;
	}
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}
	
}
