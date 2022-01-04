package com.bridgelabz.addressbookapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exceptions.PersonException;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import com.bridgelabz.addressbookapp.repository.IAddressBookRepository;

/**
 * Service layer :Business logic implementation
 */

@Service
public class AddressBookService implements IAddressBookService {
	@Autowired
	private IAddressBookRepository addressBook;

	/**
	 * To call post method to create address book
	 * @param AddressBookDTO
	 * @return : addressBookData with addressbookId
	 */
	@Override
	public AddressBookModel createAddressBookData(AddressBookDTO bookDTO) {
		AddressBookModel addressBookData = null;
		addressBookData = new AddressBookModel(bookDTO);
		return addressBook.save(addressBookData);
	}

	/**
	 * To call put method to update address book by addressbookId 
	 * @param : addressbookId, AddressBookDTO
	 * @return : update data of addressBookData
	 */
	@Override
	public AddressBookModel updateAddressBookData(int addressbookId, AddressBookDTO bookDTO) {
		AddressBookModel addressBookData = this.getAddressBookDataById(addressbookId);
		addressBookData.updateAddressBookData(bookDTO);
		return addressBook.save(addressBookData);
	}

	/**
	 * To call get method to get all address book
	 * @return : addressBookList
	 */
	@Override
	public List<AddressBookModel> getAddressBookData() {
		return addressBook.findAll();
	}

	/**
	 * To call get method to get address book by addressbookId
	 * @param : addressbookId
	 * @return : addressBookData
	 */
	@Override
	public AddressBookModel getAddressBookDataById(int addressbookId) {
		return addressBook.findById(addressbookId).orElseThrow(
				() -> new PersonException("address book with id " + addressbookId + " does not exist !..."));
	}

	/**
	 * To call delete method to delete address book by addressbookId 
	 * @param : addressbookId
	 * @return : addressBookData
	 */
	@Override
	public void deleteAddressBookData(int addressbookId) {
		AddressBookModel addressBookData = this.getAddressBookDataById(addressbookId);
		addressBook.delete(addressBookData);
	}

}