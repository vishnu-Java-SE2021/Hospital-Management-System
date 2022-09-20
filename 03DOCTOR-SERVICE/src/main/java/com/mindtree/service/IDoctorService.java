//IDoctorService.java
package com.mindtree.service;

import java.util.List; 

import com.mindtree.entity.Doctor;

public interface IDoctorService {
	
	public List<Doctor> fetchAllDoctors();
	
	public Doctor fetchADoctor(int docId);
	
	public Doctor fetchADoctorByName(String name);
	
	public Doctor addDoctor(Doctor doc);

	public List<String> fetchAllDoctorsNames();
	
	public void setDocPatientCount(String name, int count);
	
}
