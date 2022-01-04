package com.bridgelabz.addressbookapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

/**
 * @Data : Auto Generating getters and setters, constructor, toString
 *
 */
public @Data class PersonDTO {

	/**
	 * regex pattern for first name
	 */
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$", message = "First name Invalid")
	@NotBlank(message = "First name can not be null")
	public String fName;
	
	/**
	 * regex pattern for last name
	 */
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$", message = "Last name Invalid")
	@NotBlank(message = "Last name can not be null")
	public String lName;
	
	/**
	 * regex pattern for gender
	 */
	@Pattern(regexp = "male|female", message = "Gender needs to either male or female")
	@NotBlank(message = "Gender can not be null")
	public String gender;

	/**
	 * regex pattern for phoneNumber
	 */
	@Pattern(regexp = "^((0091)|(\\+91)|0?)[789]{1}\\d{9}$", message = "phone Number is invalid")
	@NotBlank(message = "phone Number can not be null")
	public String phoneNumber;

	/**
	 * regex pattern for email address
	 */
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "email is invalid")
	@NotBlank(message = "email can not be null")
	public String email;

	@NotBlank(message = "Address can not be null")
	public String address;

	@NotBlank(message = "city can not be null")
	public String city;

	@NotBlank(message = "State can not be null")
	public String state;

	
	@NotBlank(message = "Country can not be null")
	public String country;

	
	@NotBlank(message = "profilePic can not be null")
	public String profilePic;
	


}