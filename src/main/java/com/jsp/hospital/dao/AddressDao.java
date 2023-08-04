package com.jsp.hospital.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital.dto.Address;
import com.jsp.hospital.repository.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepo repo;
	
	
	public Address saveAddress(Address address) {
		return repo.save(address);
	}
	
	public Address updateAddress(int addressId,Address address) {
		Optional<Address> optional=repo.findById(addressId);
		if(optional.isPresent()){
			address.setAddressId(addressId);
            return repo.save(address);
		}
		return null;
	}
	public Address findAddressById(int id) {
		Optional<Address> optional=repo.findById(id);
		if(optional.isPresent()){
			return optional.get();
		}
		return null;
	}
	
	public Address deleteAddressById(int addressId) {
		Optional<Address> optional=repo.findById(addressId);
		if(optional.isPresent()){
			repo.delete(optional.get());
			return optional.get();
		}
		return null;
	}
	
}
