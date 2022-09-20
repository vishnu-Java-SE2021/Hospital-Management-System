import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-show-doctor',
  templateUrl: './show-doctor.component.html',
  styleUrls: ['./show-doctor.component.css']
})
export class ShowDoctorComponent implements OnInit {

  constructor(private doctorService:DoctorService) { }

  doctorDetails:Doctor = new Doctor();  //to fetch and display all details of a doctor

  doctorsNames:String[] = [];  //to fetch and store all doctors names

  dataPresent:Boolean = false;  // to verify doctor details are present

  doctorName:String = "";  // to bind doctor name

  errMsg = "";  //to display error message

  ngOnInit(): void {
    this.doctorService.getAllDoctorsNames().subscribe(data => {
      this.doctorsNames=data;
    
    },error=> console.log(error));
  }

  showDoctorInfo(showDoctorForm: any) {
    console.log(showDoctorForm);

    var docName = showDoctorForm.value.doctorName;

    if (docName !== "") {
      this.doctorService.getDoctorByName(this.doctorName).subscribe(data => {
        this.doctorDetails=data;
        this.dataPresent = true;
        this.errMsg = "";
        console.log(data);
      },error=> console.log(error));
      
    }else
        this.errMsg = "Please select a doctor";
  }

}

