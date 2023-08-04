package com.jsp.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospital.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
