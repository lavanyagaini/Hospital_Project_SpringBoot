package com.jsp.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospital.dto.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer>{

}
