import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})

export class AddPatientComponent implements OnInit {
  patient: Patient = new Patient();

  doctorsNames:String[]=[];

  constructor(private patientService:PatientService,private doctorService:DoctorService ,private router:Router,
                        private datePipe:DatePipe) { }


  ngOnInit(): void {
      this.doctorService.getAllDoctorsNames().subscribe(data => {
        this.doctorsNames=data;
      },error=> console.log(error));
  }

  addPatient(patient:Patient){
    this.patientService.addPatient(patient).subscribe(data=>{
      console.log(data)
    },error=>console.log(error)
    );
  }

  showPatientsList(){
    this.router.navigate(['patients-list']);
  }

  submit(){
    console.log(this.patient);
    this.datePipe.transform(this.patient.dateOfVisit, "M/d/yy");
    this.addPatient(this.patient);
    this.showPatientsList();
  }
}
