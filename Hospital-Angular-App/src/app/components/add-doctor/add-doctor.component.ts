import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';
import { Router } from '@angular/router';
import list from '../add-doctor/specialist.json';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {

  doctor: Doctor = new Doctor();
  specialistList: { specialist: String[] }[] = list;
  specializations: String[] = [];

  constructor(private doctorService: DoctorService, private router: Router) { }

  ngOnInit(): void {
    this.specializations = this.specialistList[0].specialist;
  }

  addDoctor(doctor: Doctor) {
    this.doctorService.addDoctor(doctor).subscribe(data => {
      console.log(data)
    }, error => console.log(error)
    );
  }

  showDoctorsList(){
    this.router.navigate(['doctors-list']);
  }

  submit() {
    console.log(this.doctor);
    this.addDoctor(this.doctor);
    this.showDoctorsList();
  }
}

