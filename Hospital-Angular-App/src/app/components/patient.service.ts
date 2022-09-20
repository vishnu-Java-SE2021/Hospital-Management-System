import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patient } from '../components/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private patientUrl = 'http://localhost:9100/patient';

  constructor(private http:HttpClient) { }

  getAllPatients():Observable<Patient[]>{
    return this.http.get<Patient[]>(`${this.patientUrl}/getAllPatients`);
  }

  addPatient(patient:Patient):Observable<Patient>{
    return  this.http.post<Patient>(`${this.patientUrl}/add`,patient);
  }

  getPatientById(id:Number): Observable<Patient>{
    return this.http.get<Patient>(`${this.patientUrl}/getPatient/${id}`);
  }


}
