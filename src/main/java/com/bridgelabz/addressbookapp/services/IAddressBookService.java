package com.bridgelabz.addressbookapp.services;

import java.util.List;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
public interface IAddressBookService {
	
	AddressBookModel createAddressBookData(AddressBookDTO bookDTO);

	AddressBookModel updateAddressBookData(int addressbookId, AddressBookDTO bookDTO);

	List<AddressBookModel> getAddressBookData();

	AddressBookModel getAddressBookDataById(int id);

	void deleteAddressBookData(int id);
}
