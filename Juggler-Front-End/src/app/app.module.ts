import { DistributionRegisterformComponent } from './distribution-registerform/distribution-registerform.component';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { MoviedetailsFormComponent } from './moviedetails-form/moviedetails-form.component';
import { AuthenticationService } from './authentication.service';
import { AlertService } from './alert.service';
import { MatCardModule, MatButtonModule } from '@angular/material';


// import { MatToolbarModule, MatSidenavModule, MatIconModule, MatListModule, MatCardModule } from '@angular/material';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    routingComponents,
    UserLoginComponent,
    MoviedetailsFormComponent
  ],

  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MDBBootstrapModule.forRoot(),
    AppRoutingModule,
    ReactiveFormsModule,
    MatCardModule,
    MatButtonModule
  ],
  providers: [AuthenticationService, AlertService],
  bootstrap: [AppComponent],
  schemas: [ NO_ERRORS_SCHEMA ]
})
export class AppModule { }
