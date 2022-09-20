import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { HttpClientModule } from '@angular/common/http';
import {MatCardModule} from '@angular/material/card';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatRadioModule} from '@angular/material/radio';
import {MatIconModule} from '@angular/material/icon';
import {DatePipe} from '@angular/common'; 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomePageComponent } from './components/home-page/home-page.component';
import { AddDoctorComponent } from './components/add-doctor/add-doctor.component';
import { ShowDoctorComponent } from './components/show-doctor/show-doctor.component';
import { AddPatientComponent } from './components/add-patient/add-patient.component';
import { ShowPatientComponent } from './components/show-patient/show-patient.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { ServicesComponent } from './components/services/services.component';
import { DoctorsListComponent } from './components/doctors-list/doctors-list.component';
import { PatientsListComponent } from './components/patients-list/patients-list.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    AddDoctorComponent,
    ShowDoctorComponent,
    AddPatientComponent,
    ShowPatientComponent,
    AboutUsComponent,
    ContactUsComponent,
    ServicesComponent,
    DoctorsListComponent,
    PatientsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatSelectModule,
    HttpClientModule,
    MatCardModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatRadioModule,
    MatIconModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
