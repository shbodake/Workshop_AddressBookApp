package com.bridgelabz.addressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.addressbookapp.model.AddressBookModel;

@Repository
public interface IAddressBookRepository extends JpaRepository<AddressBookModel, Integer> {

}
