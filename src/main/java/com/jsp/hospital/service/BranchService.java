package com.jsp.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital.dao.AddressDao;
import com.jsp.hospital.dao.BranchDao;
import com.jsp.hospital.dao.HospitalDao;
import com.jsp.hospital.dto.Address;
import com.jsp.hospital.dto.Branch;
import com.jsp.hospital.dto.Hospital;
import com.jsp.hospital.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
	private BranchDao branchDao;
	
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(int hospitalId, int addressId, Branch branch) {
		Hospital dbHospital=hospitalDao.findById(hospitalId);
		if(dbHospital!=null) {
           Address dbAddress=addressDao.findAddressById(addressId);
           if(dbAddress!=null) {
             branch.setHospital(dbHospital);
             branch.setAddress(dbAddress);
            Branch dbBranch=branchDao.saveBranch(branch);
            ResponseStructure<Branch>  structure=new ResponseStructure<Branch>();
            structure.setMessage("Branch Added successfully");
            structure.setStatus(HttpStatus.CREATED.value());
            structure.setData(dbBranch);
            return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);
           }
           else {
        	   return null;
//        	   raise addressNOTFOUNDexception
           }
			
			
		}else {
			return null;
//			raise hospital id not found exception
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int branchId, Branch branch) {
       Branch dbBranch=branchDao.updateBranch(branchId,branch);
       if(dbBranch!=null) {
    	   ResponseStructure<Branch>  structure=new ResponseStructure<Branch>();
           structure.setMessage("Branch updated successfully");
           structure.setStatus(HttpStatus.CREATED.value());
           structure.setData(dbBranch);
           return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);
       }else {
    	   return null;
//    	   raise branch id not found exception
       }
	}

	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int branchId) {
		Branch dbBranch=branchDao.getBranchById(branchId);
		 if(dbBranch!=null) {
	    	   ResponseStructure<Branch>  structure=new ResponseStructure<Branch>();
	           structure.setMessage("Branch data fetched  successfully");
	           structure.setStatus(HttpStatus.FOUND.value());
	           structure.setData(dbBranch);
	           return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.FOUND);
	       }else {
	    	   return null;
//	    	   raise branch id not found exception
	       }
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) {
		Branch dbBranch=branchDao.deleteBranchById(branchId);
		 if(dbBranch!=null) {
	    	   ResponseStructure<Branch>  structure=new ResponseStructure<Branch>();
	           structure.setMessage("Branch data deleted  successfully");
	           structure.setStatus(HttpStatus.FOUND.value());
	           structure.setData(dbBranch);
	           return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.FOUND);
	       }else {
	    	   return null;
//	    	   raise branch id not found exception
	       }
	}

}
