import { DistributionRegisterformComponent } from './distribution-registerform/distribution-registerform.component';


import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { PartnerRegisterComponent } from './partner-register/partner-register.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [{ path: '', component: LandingPageComponent } ,
{ path: 'home', component: HomePageComponent } ,
{ path: 'register-user', component: UserRegisterComponent } ,
{ path: 'login-user', component: UserLoginComponent } ,
{ path: 'register-partner', component: PartnerRegisterComponent },

{ path: 'login', component: LoginComponent },


{ path: 'distributer',component:DistributionRegisterformComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

export const routingComponents = [ LandingPageComponent, UserRegisterComponent , LoginComponent,
  UserLoginComponent, PartnerRegisterComponent, HomePageComponent];

