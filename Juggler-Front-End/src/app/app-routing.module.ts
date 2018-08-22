import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
<<<<<<< HEAD
import { LandingPageComponent } from './landing-page/landing-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { PartnerRegisterComponent } from './partner-register/partner-register.component';
=======
<<<<<<< HEAD

const routes: Routes = [];
=======
import { PartnerRegisterComponent } from './partner-register/partner-register.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { HomePageComponent } from './home-page/home-page.component';
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d

const routes: Routes = [{ path: '', component: LandingPageComponent } ,
{ path: 'home', component: HomePageComponent } ,
{ path: 'register-user', component: UserRegisterComponent } ,
{ path: 'login-user', component: UserLoginComponent } ,
{ path: 'register-partner', component: PartnerRegisterComponent }];
<<<<<<< HEAD
=======
>>>>>>> 5982038d65e576e1e833306c2294636a2478ce34
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
<<<<<<< HEAD
export const routingComponents = [ LandingPageComponent, UserRegisterComponent ,
  UserLoginComponent, PartnerRegisterComponent, HomePageComponent ];

=======
<<<<<<< HEAD
export const routingComponents = [ ];

=======
export const routingComponents = [ LandingPageComponent, UserRegisterComponent ,
  UserLoginComponent, PartnerRegisterComponent, HomePageComponent];
>>>>>>> 5982038d65e576e1e833306c2294636a2478ce34
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d
