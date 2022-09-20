import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-patients-list',
  templateUrl: './patients-list.component.html',
  styleUrls: ['./patients-list.component.css']
})
export class PatientsListComponent implements OnInit {

  patients: Patient[] = [];
  
  constructor(private patientService: PatientService) { }

  ngOnInit(): void {
    this.patientService.getAllPatients().subscribe((data) => {       
      this.patients = data;
      console.log(data);
    }, (error) => console.log(error))
  }

}
