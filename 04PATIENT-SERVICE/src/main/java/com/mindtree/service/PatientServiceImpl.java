//PatientServiceImpl.java
package com.mindtree.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mindtree.entity.Patient;
import com.mindtree.exception.PatientNotFoundException;
import com.mindtree.repo.IPatientRepo;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientRepo patientRepo;
	
	@Autowired
	private RestTemplate template;
	
	//URI to locate Doctor MicroService
	private static final String URl="http://localhost:9100/doctor/";
	private static String patientCountUpdatePath=URl+"update/count/";
	
	@Override
	public List<Patient> fetchAllPatients() {
		return patientRepo.findAll();
	}
	
	@Override
	public Patient fetchAPatient(int pId) {
		
		Optional<Patient> opt = patientRepo.findById(pId);
		
		if(opt.isPresent()){
			Patient pat= opt.get();
			
			return pat;
		}
		throw new PatientNotFoundException("No Patient found with id : "+pId);
	}


	@Override
	public Patient addPatient(Patient pat) {
		Patient savedPatient = patientRepo.save(pat);
		
		if(template!=null)
			template.getForObject(patientCountUpdatePath+pat.getVisitedDoc()+"/1", String.class);
		return savedPatient;
	}
	
}
