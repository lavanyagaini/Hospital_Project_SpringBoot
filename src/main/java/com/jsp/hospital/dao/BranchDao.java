package com.jsp.hospital.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital.dto.Branch;
import com.jsp.hospital.repository.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepo repo;

	public Branch saveBranch(Branch branch) {
	
		return repo.save(branch);
	}

	public Branch updateBranch(int branchId, Branch branch) {
		Optional<Branch> optional=repo.findById(branchId);
		if(optional.isPresent()) {
			branch.setBranchId(branchId);
			branch.setHospital(optional.get().getHospital());
			branch.setAddress(optional.get().getAddress());
			return repo.save(branch);
		}
		return null;
	}

	public Branch getBranchById(int branchId) {
		Optional<Branch> optional=repo.findById(branchId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Branch deleteBranchById(int branchId) {
		Optional<Branch> optional=repo.findById(branchId);
		if(optional.isPresent()) {
			Branch branch=optional.get();
			repo.delete(branch);
			return branch;
		}
		return null;
	} 

}
