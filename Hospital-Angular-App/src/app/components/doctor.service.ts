import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from './doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  doctorUrl = "http://localhost:9100/doctor";

  constructor(private http:HttpClient) { }

  getAllDoctors():Observable<Doctor[]>{
      return this.http.get<Doctor[]>(`${this.doctorUrl}/getAllDoctors`);
  }

  getAllDoctorsNames():Observable<String[]>{
    return this.http.get<String[]>(`${this.doctorUrl}/getAllDoctorsNames`);
  }

  getDoctorByName(name:String):Observable<Doctor>{
    return this.http.get<Doctor>(`${this.doctorUrl}/getDoctorByName/${name}`);
  }

  addDoctor(doctor:Doctor):Observable<Doctor>{
    return  this.http.post<Doctor>(`${this.doctorUrl}/add`,doctor);
  }
  
}
