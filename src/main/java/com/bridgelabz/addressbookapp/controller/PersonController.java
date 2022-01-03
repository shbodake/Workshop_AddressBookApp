package com.bridgelabz.addressbookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapp.dto.PersonDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.PersonData;
import com.bridgelabz.addressbookapp.services.IPersonService;
import com.bridgelabz.addressbookapp.services.PersonService;

/**
 * Rest Controller to handle the all REST calls.
 *
 */

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private IPersonService personService;
	/**
	 * To call Get method
	 * @return : Http status and details of the person
	 */
	@RequestMapping(value = {"/get"})
	public ResponseEntity<ResponseDTO> getPersonData(){
	List<PersonData> personList = null;
	personList = personService.getPersonData();
	ResponseDTO respDTO = new ResponseDTO("Get Call Successful", personList);
	return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	/**
	 * Call Get method
	 * @param id : contact Id
	 * @return : Http status and details of the person
	 */
	@GetMapping("/get/{contactId}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("id") int contactId){
		PersonData contactData = null;
		contactData = personService.getPersonDataById(contactId);
		ResponseDTO respDTO = new ResponseDTO("Get Call for Id Successful", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * Call post method to add details
	 * @param personDTO : details of id, ftname, lname, gender, phoneNumber, email, address, city, state, country and profilePic
	 * @return : Http status and details of the person
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> getPersonData(@RequestBody PersonDTO personDTO){
		PersonData contactData = null;
		contactData = personService.createPersonData(personDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Person data Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * To call put method to update details
	 * @param personDTO : details of id, ftname, lname, gender, phoneNumber, email, address, city, state, country and profilePic
	 * @return : Http status and details of the person
	 */
	@PutMapping("/update/{contactId}")
	public ResponseEntity<ResponseDTO> updatePersonData(@PathVariable("contactId")int contactId, @RequestBody PersonDTO personDTO){
		PersonData contactData = null;
		contactData = personService.updatePersonData(1, personDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Person data Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * To call delete method to remove person details
	 * @param empId : Person id
	 * @return : contact id which is deleted
	 */
	@DeleteMapping("/delete/{contactId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("contactId") int contactId){
		personService.deletePersonData(contactId);
		ResponseDTO respDTO = new ResponseDTO("Deleted Person data Successfully", "Deleted id : " +contactId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
	
