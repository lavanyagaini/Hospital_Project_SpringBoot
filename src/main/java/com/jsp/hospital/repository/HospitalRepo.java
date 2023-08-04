package com.jsp.hospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hospital.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer>{

	@Query("select h from Hospital h where h.name=?1")
	public Hospital findByName(String name);

}