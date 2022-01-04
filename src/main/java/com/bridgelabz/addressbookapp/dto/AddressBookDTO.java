package com.bridgelabz.addressbookapp.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.bridgelabz.addressbookapp.model.PersonData;

import lombok.Data;
/**
 * Data transfer Object : AddressBookDTO
 *
 */
public @Data class AddressBookDTO {
	
	//regex pattern for address book
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Address Book name Invalid") 
	@NotNull(message = "address Book Name can not be null")
	public String addressBookName;
	
}
