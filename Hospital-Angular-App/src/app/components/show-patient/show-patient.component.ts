import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-show-patient',
  templateUrl: './show-patient.component.html',
  styleUrls: ['./show-patient.component.css']
})
export class ShowPatientComponent implements OnInit {

  patient: Patient = new Patient();

  id: string = "";

  dataPresent: Boolean = false;

  errMsg: String = "";

  constructor(private patientService: PatientService) { }

  ngOnInit(): void { }


  showPatientInfo() {
    if (this.id!= ""){
        var id = parseInt(this.id);

        this.patientService.getPatientById(id).subscribe((data: Patient) => {
        this.patient = data;
        this.dataPresent = true;
        this.errMsg = "";
        console.log(data);
      }, (error) => {
        console.log(error)
        this.dataPresent = false;
        this.errMsg = "No Patient Found with id :: "+ this.id;
      })
    }

  }
}
