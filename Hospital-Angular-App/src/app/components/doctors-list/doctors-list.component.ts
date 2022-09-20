import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-doctors-list',
  templateUrl: './doctors-list.component.html',
  styleUrls: ['./doctors-list.component.css']
})
export class DoctorsListComponent implements OnInit {

  doctors: Doctor[] = [];
  
  constructor(private doctorService: DoctorService) { }

  ngOnInit(): void {
    this.doctorService.getAllDoctors().subscribe((data) => {       
      this.doctors = data;
      console.log(data);
    }, (error) => console.log(error))
  }


}
