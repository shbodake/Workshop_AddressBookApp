package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

/**
 * @Data : Auto Generate getters and setters, constructor, toString
 *
 */

public @Data class PersonDTO {
	public String fName;
	public String lName;
	public String gender;
	public long phoneNumber;
	public String email;
	public String address;
	public String city;
	public String state;
	public String country;
	public String profilePic;
	
	public PersonDTO( String fName, String lName, String gender, long phoneNumber, String email,
			String address, String city, String state, String country, String ProfilePic) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.profilePic = profilePic ;
	}
}
