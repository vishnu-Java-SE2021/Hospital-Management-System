//IPatientService.java
package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Patient;

public interface IPatientService {

	public List<Patient> fetchAllPatients();

	public Patient fetchAPatient(int patId);

	public Patient addPatient(Patient pat);

}
