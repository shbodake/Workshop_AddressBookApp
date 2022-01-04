package com.bridgelabz.addressbookapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import com.bridgelabz.addressbookapp.repository.IAddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {
	@Autowired
	private IAddressBookRepository addressBook;

	/**
	 * To create address book
	 * @param AddressBookDTO
	 * @return : addressBookData
	 */
	@Override
	public AddressBookModel createAddressBookData(AddressBookDTO bookDTO) {
		AddressBookModel addressBookData = null;
		addressBookData = new AddressBookModel(bookDTO);
		return addressBook.save(addressBookData);
	}

	/**
	 * To update address book by addressbookId 
	 * @param : addressbookId, AddressBookDTO
	 * @return : addressBookData
	 */
	@Override
	public AddressBookModel updateAddressBookData(int addressbookId, AddressBookDTO bookDTO) {
		AddressBookModel addressBookData = this.getAddressBookDataById(addressbookId);
		addressBookData.updateAddressBookData(bookDTO);
		return addressBook.save(addressBookData);
	}

	/**
	 * To get all address book
	 * @return : addressBookData
	 */
	@Override
	public List<AddressBookModel> getAddressBookData() {
		return addressBook.findAll();
	}

	/**
	 * To get address book by addressbookId
	 * @param : addressbookId
	 * @return : addressBookData
	 */
	@Override
	public AddressBookModel getAddressBookDataById(int addressbookId) {
		return addressBook.findById(addressbookId).get();
	}

	/**
	 * To delete address book by addressbookId 
	 * @param : addressbookId
	 * @return : addressBookData
	 */
	@Override
	public void deleteAddressBookData(int addressbookId) {
		AddressBookModel addressBookData = this.getAddressBookDataById(addressbookId);
		addressBook.delete(addressBookData);
	}

}