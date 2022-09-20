//Patient.java
package com.mindtree.entity;

import java.io.Serializable; 
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PATIENT_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient implements Serializable {

	@Id
	@SequenceGenerator(name="Patient_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "Patient_SEQ",strategy = GenerationType.AUTO)
	@Column(name = "PID")
	private int id;

	@Column(name="PNAME",length = 25,nullable = false)
	private String name;
	
	@Column(name="VISTED_DOCTOR",length = 25,nullable = false)
	private String visitedDoc;
	
	@Column(name="VISITED_DATE",nullable = false)
	private Date dateOfVisit;
	
	@Column(name="PRESCRIPTION",length = 150,nullable = false)
	private String Prescription;
}
