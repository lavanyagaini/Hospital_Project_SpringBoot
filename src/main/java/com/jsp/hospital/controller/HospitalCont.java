package com.jsp.hospital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospital.dto.Hospital;
import com.jsp.hospital.service.HospitalService;
import com.jsp.hospital.util.ResponseStructure;

@RestController
public class HospitalCont {
	@Autowired
	private HospitalService service;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody @Valid Hospital hospital){
		return service.saveHospital(hospital);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(@RequestParam int id){
		return service.deleteHospitalById(id);
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<ResponseStructure<List<Hospital>>> deleteAllHospital(){
		return service.deleteAllHospital();
	}
	
	@GetMapping("/fetchByName")
	public ResponseEntity<ResponseStructure<Hospital>>  FindHospitalByName(@RequestParam String name){
		return service.FindHospitalByName(name);
	}
	
	@GetMapping("/findById")
	public ResponseEntity<ResponseStructure<Hospital>>  findById(@RequestParam int id){
		return service.findById(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestBody Hospital hospital,@RequestParam int id){
		return service.updateHospital(hospital,id);
	}
	
	@GetMapping("/findAll")
	
	public ResponseEntity<ResponseStructure<List<Hospital>>> GetAllHospital(@RequestBody Hospital hospital){
		return service.GetAllHospital(hospital);
		
	}

	
	
	
	
	
	
}
