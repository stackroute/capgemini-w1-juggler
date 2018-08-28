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
import { UserLoginComponent } from './login/user-login/user-login.component';
import { MoviedetailsFormComponent } from './moviedetails-form/moviedetails-form.component';
import { AuthenticationService } from './authentication.service';
import { AlertService } from './alert.service';
import { MatCardModule, MatButtonModule, MatStepperModule, MatGridListModule } from '@angular/material';
import { MaterialsModule } from './materials';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { PartnerLoginComponent } from './login/partner-login/partner-login.component';
import { TheatreRegistrationComponent } from './theatre-registration/theatre-registration.component';
import { SearchDataService } from './search-data.service';
import { TheatreService } from './theatre.service';
import { UserService } from './user.service';
import { ContactComponent } from './contact/contact.component';


// import { MatToolbarModule, MatSidenavModule, MatIconModule, MatListModule, MatCardModule } from '@angular/material';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    routingComponents,
    UserLoginComponent,
    MoviedetailsFormComponent,
    DistributionRegisterformComponent,
    PartnerLoginComponent,
    TheatreRegistrationComponent,
    ContactComponent
  ],

  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MDBBootstrapModule.forRoot(),
    AppRoutingModule,
    ReactiveFormsModule,
    MaterialsModule,
    MatCardModule,
    MatButtonModule,
    MatStepperModule,
    MatInputModule,
    MatFormFieldModule,
    MatGridListModule
  ],
  providers: [AuthenticationService, AlertService, SearchDataService, TheatreService, UserService],
  bootstrap: [AppComponent],
  schemas: [ NO_ERRORS_SCHEMA ]
})
export class AppModule { }

