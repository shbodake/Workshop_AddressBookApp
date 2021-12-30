package com.bridgelabz.addressbookapp.services;

import java.util.List;

import com.bridgelabz.addressbookapp.dto.PersonDTO;
import com.bridgelabz.addressbookapp.model.PersonData;

public interface IPersonService {
	
	List<PersonData> getPersonData();
	
	PersonData getPersonDataById(long id);
	
	PersonData createPersonData(PersonDTO personDTO);
	
	PersonData updatePersonData(long id,PersonDTO personDTO);
	
	void deletePersonData(long id);
}
