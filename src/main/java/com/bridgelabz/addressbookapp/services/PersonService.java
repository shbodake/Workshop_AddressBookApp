package com.bridgelabz.addressbookapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.addressbookapp.dto.PersonDTO;
import com.bridgelabz.addressbookapp.model.PersonData;
import com.bridgelabz.addressbookapp.repository.IPersonRepository;

/**
 * PersonService : Business logic implemetation
 *
 */

@Service
public class PersonService implements IPersonService{
	
	@Autowired
	private IPersonRepository personRepository;
	
	/**
	 * To call Get method
	 * @return : details of the person
	 */
	@Override
	public List<PersonData> getPersonData() {
		return personRepository.findAll();
	}

	/**
	 * To call Get method
	 * @param id : contact Id
	 * @return : details of the person
	 */
	@Override
	public PersonData getPersonDataById(long id) {
		return personRepository.findById(id).get();
		
	}

	/**
	 * To call post method to add details
	 * @param personDTO : details id, ftname, lname, gender, phoneNumber, email, address, city, state, country and profilePic
	 * @return : details of the person
	 */
	@Override
	public PersonData createPersonData(PersonDTO personDTO) {
		PersonData contactData = null;
		contactData = new PersonData(personDTO);
		return personRepository.save(contactData);
	}

	/**
	 * To call put method to update details
	 * @param personDTO : details id, ftname, lname, gender, phoneNumber, email, address, city, state, country and profilePic
	 * @return : details of the person
	 */
	@Override
	public PersonData updatePersonData(long id, PersonDTO personDTO) {
		PersonData contactData = this.getPersonDataById(id);
		contactData.updatePersonData(personDTO);
		return personRepository.save(contactData);
	}

	/**
	 * To call delete method to remove person details
	 * @param empId : Person id
	 * @return : person id which is deleted
	 */
	@Override
	public void deletePersonData(long id) {
		PersonData contactData  = this.getPersonDataById(id);
		personRepository.delete(contactData );
	}
}
