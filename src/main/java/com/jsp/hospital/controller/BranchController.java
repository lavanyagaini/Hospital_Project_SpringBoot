package com.jsp.hospital.controller;

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

import com.jsp.hospital.dto.Branch;
import com.jsp.hospital.service.BranchService;
import com.jsp.hospital.util.ResponseStructure;

@RestController
@RequestMapping("/branch")
public class BranchController {
	
	@Autowired
	private BranchService service;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch
	(@RequestParam int hospitalId,@RequestParam int addressId,@RequestBody Branch branch){
		return service.saveBranch(hospitalId,addressId,branch);
	}
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int branchId,@RequestBody Branch branch){
		return service.updateBranch(branchId,branch);
	}
	@GetMapping("/findById")
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@RequestParam int branchId){
		return service.getBranchById(branchId);
	}
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(@RequestParam int branchId){
    	return service.deleteBranchById(branchId);
    }
	
	
}
