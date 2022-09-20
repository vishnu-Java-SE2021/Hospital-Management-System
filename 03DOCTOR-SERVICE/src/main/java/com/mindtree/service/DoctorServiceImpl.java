//DoctorServiceImpl.java
package com.mindtree.service;

import java.util.ArrayList; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.entity.Doctor;
import com.mindtree.exception.DoctorNotFoundException;
import com.mindtree.repo.IDoctorRepo;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	IDoctorRepo docRepo;
	
	@Override
	public List<Doctor> fetchAllDoctors() {
		return docRepo.findAll();
	}

	@Override
	public Doctor fetchADoctor(int docId) {
		
		Optional<Doctor> opt = docRepo.findById(docId);
		
		if(opt.isPresent()){
			Doctor doc = opt.get();
			
			return doc;
		}
		throw new DoctorNotFoundException("No Doctor found with id : "+docId);
	}
	
	@Override
	public Doctor fetchADoctorByName(String name) {
		
		return docRepo.findByName(name);
	}

	@Override
	public Doctor addDoctor(Doctor doc) {
		doc.setPCount(0);
		return docRepo.save(doc);
	}

	@Override
	public List<String> fetchAllDoctorsNames() {
		List<Doctor> doctors = docRepo.findAll();
		
		List<String> docNames = new ArrayList<>();
		
		for(Doctor doc : doctors)
			docNames.add(doc.getName());
		
		return docNames;
	}
	
	@Override
	public void setDocPatientCount(String name, int count) {
		
		Doctor doc =  docRepo.findByName(name);
		
		if(doc!=null) {
			int pcount = doc.getPCount(); 
			
			if(count>0) {
				pcount+=count; 
				doc.setPCount(pcount);
				docRepo.save(doc);
			}	
		}	
	}
	

}
