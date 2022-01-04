package com.bridgelabz.addressbookapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import com.bridgelabz.addressbookapp.services.IAddressBookService;


@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;

	/**
	 * To call post method to create address book 
	 * @param AddressBookDTO
	 * @return : ResponseDTO
	 */
	@PostMapping("/Create")
	public ResponseEntity<ResponseDTO> createAddressBookData(@Valid @RequestBody AddressBookDTO bookDTO) {
		AddressBookModel addressBook = null;
		addressBook = addressBookService.createAddressBookData(bookDTO);
		ResponseDTO respDTO = new ResponseDTO("created address book successfully", addressBook);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * To call put method to update address book by addressbookId
	 * @param : addressbookId, AddressBookDTO
	 * @return : ResponseDTO
	 */
	@PutMapping("Update")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@RequestParam int addressbookId,@RequestBody AddressBookDTO bookDTO) {
		AddressBookModel addressBook = null;
    		addressBook = addressBookService.updateAddressBookData(addressbookId,bookDTO);
		ResponseDTO respDTO = new ResponseDTO("created address book successfully", addressBook);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * To get all address book
	 * @return : ResponseDTO
	 */
	@RequestMapping("/getAll")
	public ResponseEntity<ResponseDTO> getAllAddressBookData() {
		List<AddressBookModel> addressBookList = null;
		addressBookList = addressBookService.getAddressBookData();
		ResponseDTO respDTO = new ResponseDTO("Get call success", addressBookList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * To call get method 
	 * @param : addressbookId
	 * @return : ResponseDTO
	 */
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getAddressBookData(@RequestParam int addressbookId) {
		AddressBookModel contactDetails = null;
		contactDetails = addressBookService.getAddressBookDataById(addressbookId);
		ResponseDTO respDTO = new ResponseDTO("Get call success for id:" + addressbookId, contactDetails);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * To call delete method to remove person details by addressbookId
	 * @param : addressbookId
	 * @return : ResponseDTO
	 */
	@DeleteMapping("/Delete")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@RequestParam int addressbookId) {
		addressBookService.deleteAddressBookData(addressbookId);
		ResponseDTO respDTO = new ResponseDTO("Deleted AddressBook data Successfully", "deleted addressbookId is :" + addressbookId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

}