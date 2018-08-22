<<<<<<< HEAD

=======
<<<<<<< HEAD
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
=======
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
<<<<<<< HEAD
=======
import { UserLoginComponent } from './user-login/user-login.component';
>>>>>>> 5982038d65e576e1e833306c2294636a2478ce34
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
<<<<<<< HEAD
    FooterComponent,
    routingComponents
=======
<<<<<<< HEAD
    FooterComponent
=======
    FooterComponent,
    routingComponents,
    UserLoginComponent
>>>>>>> 5982038d65e576e1e833306c2294636a2478ce34
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d
  ],
  imports: [
    BrowserModule,
    FormsModule,
<<<<<<< HEAD
    AppRoutingModule,
    MDBBootstrapModule.forRoot(),
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [ NO_ERRORS_SCHEMA ]

=======
<<<<<<< HEAD
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
=======
    HttpClientModule,
    BrowserAnimationsModule,
    MDBBootstrapModule.forRoot(),
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [ NO_ERRORS_SCHEMA ]
>>>>>>> 5982038d65e576e1e833306c2294636a2478ce34
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d
})
export class AppModule { }
