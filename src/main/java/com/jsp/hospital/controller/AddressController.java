package com.jsp.hospital.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospital.dto.Address;
import com.jsp.hospital.dto.Branch;
import com.jsp.hospital.service.AddressService;
import com.jsp.hospital.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService  service;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid @RequestBody Address address){
		return service.saveAddress(address);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int addressId,@RequestBody Address address){
		return service.updateAddress(addressId,address);
	}
	@GetMapping("/findById")
	public ResponseEntity<ResponseStructure<Address>> findAddressById(@RequestParam int addressId){
		return service.findAddressById(addressId);
	}
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int addressId){
    	return service.deleteAddressById(addressId);
    }
}
