package com.jsp.hospital.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital.dto.Hospital;
import com.jsp.hospital.repository.HospitalRepo;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepo repo;

	public Hospital saveHospital(Hospital hospital) {
//		Optional<Hospital> optional=repo.findById(hospital.getId());  //existing id
//		if(optional.isPresent()) {
//			repo.save(hospital);
//		}
		return repo.save(hospital);
	}

	public Hospital deleteHospital(int id) {
	Optional<Hospital> optional=repo.findById(id);
	if(optional.isPresent()) {
		repo.delete(optional.get());

		return optional.get();
	}
		return null;
	}
	public List<Hospital> deleteAllHospital(){
		List<Hospital> hospitals=repo.findAll();
		repo.deleteAll();
		return hospitals;
	}


	public Hospital fetchHospitalByname(String name) {
		
		Hospital hospital=repo.findByName(name);
		if(hospital!=null) {
			return hospital;
		}
		return null;
	}

	public Hospital findById(int id) {
		Optional<Hospital> hospital=repo.findById(id);
		if(hospital.isPresent()) {
			return hospital.get();
		}
		return null;
	}

	public Hospital updateHospital(int id, Hospital hospital) {
		Optional<Hospital> hospital1=repo.findById(id);
		if(hospital1.isPresent()) {
			
			//update the data
			hospital.setId(id);
			repo.save(hospital);
			return hospital;
		}
		return null;
	}



public List<Hospital> GetAllHospital(Hospital hospital) {
	List<Hospital> hospital2=repo.findAll();
	return hospital2;
}

}
