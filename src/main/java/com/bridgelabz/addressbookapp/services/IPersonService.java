package com.bridgelabz.addressbookapp.services;

import java.util.List;

import com.bridgelabz.addressbookapp.dto.PersonDTO;
import com.bridgelabz.addressbookapp.model.PersonData;

public interface IPersonService {
	
	PersonData updatePersonDta(int adddressbookId, int personId, PersonDTO personDTO);

	List<PersonData> getPersonData();

	PersonData getPersonDataById(int addressbookId,int personId);

	void deletePersonData(int addressbookId, int id);

	PersonData createPersonData(int adddressbookId, PersonDTO personDTO);
}
