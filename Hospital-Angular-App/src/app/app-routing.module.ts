import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { AddDoctorComponent } from './components/add-doctor/add-doctor.component';
import { AddPatientComponent } from './components/add-patient/add-patient.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { DoctorsListComponent } from './components/doctors-list/doctors-list.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { PatientsListComponent } from './components/patients-list/patients-list.component';
import { ServicesComponent } from './components/services/services.component';
import { ShowDoctorComponent } from './components/show-doctor/show-doctor.component';
import { ShowPatientComponent } from './components/show-patient/show-patient.component';

const routes: Routes = [

    {path:"", component: HomePageComponent, pathMatch: "full"},
    {path:"home", component: HomePageComponent, pathMatch: "full"},
    {path : "contactUs", component : ContactUsComponent, pathMatch : "full"},
    {path : "about", component : AboutUsComponent, pathMatch : "full"},
    {path : "services", component : ServicesComponent, pathMatch : "full"},
    {path : "showDoctor", component : ShowDoctorComponent, pathMatch : "full"},
    {path : "addDoctor", component : AddDoctorComponent, pathMatch : "full"},
    {path : "addPatient", component : AddPatientComponent, pathMatch : "full"},
    {path : "showPatient", component : ShowPatientComponent, pathMatch : "full"},
    {path : "doctors-list", component : DoctorsListComponent, pathMatch : "full"},
    {path : "patients-list", component : PatientsListComponent, pathMatch : "full"}
    
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
