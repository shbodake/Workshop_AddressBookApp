package com.bridgelabz.addressbookapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.addressbookapp.dto.PersonDTO;

import lombok.Data;

/**
 * Persons details
 * @Data : Auto Generate getters and setters, constructor, toString
 * @Table : person_data
 */

@Entity
@Table(name="person_details")
public @Data class PersonData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "personId")
	
	private long personId;
	private String fName;
	private String lName;
	private String gender;
	private long phoneNumber;
	private String email;
	private String address;
	private String city;
	private String state;
	private String country;
	private String profilePic;
	
	public PersonData() {}
	
	public PersonData(PersonDTO personDTO) {
		this.updatePersonData(personDTO);
	}

	public void updatePersonData(PersonDTO personDTO) {
		this.fName = personDTO.fName;
		this.lName = personDTO.lName;
		this.gender = personDTO.gender;
		this.phoneNumber = personDTO.phoneNumber;
		this.email = personDTO.email;
		this.address = personDTO.address;
		this.city = personDTO.city;
		this.state = personDTO.state;
		this.country = personDTO.country;
		this.profilePic = personDTO.profilePic;
		
	}
}
