package com.jsp.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital.dao.AddressDao;
import com.jsp.hospital.dto.Address;
import com.jsp.hospital.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		Address dbAddress = addressDao.saveAddress(address);
		ResponseStructure<Address> structure = new ResponseStructure<Address>();
		structure.setMessage("Address; data saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dbAddress);
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);

	}
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int addressId,Address  address){
		Address dbAddress=addressDao.updateAddress(addressId, address);
		if(dbAddress!=null) {
			ResponseStructure<Address> structure = new ResponseStructure<Address>();
			structure.setMessage("Address data updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		}else {
			return null;
		}
	}
	public ResponseEntity<ResponseStructure<Address>> findAddressById(int addressId){
	Address dbAddress=addressDao.findAddressById(addressId);
	if(dbAddress!=null) {
		ResponseStructure<Address> structure = new ResponseStructure<Address>();
		structure.setMessage("Address data updated successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(dbAddress);
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.FOUND);
	}else {
		return null;
	}
	}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int addressId){
		Address dbAddress=addressDao.deleteAddressById(addressId);
		if(dbAddress!=null) {
			ResponseStructure<Address> structure = new ResponseStructure<Address>();
			structure.setMessage("Address data Deleted successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.FOUND);
		}else {
			return null;
		}
	}

}
