import { MoviedetailsFormComponent } from './moviedetails-form/moviedetails-form.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { PartnerRegisterComponent } from './partner-register/partner-register.component';

const routes: Routes = [{ path: '', component: LandingPageComponent } ,
{ path: 'home', component: HomePageComponent } ,
{ path: 'register-user', component: UserRegisterComponent } ,
{ path: 'login-user', component: UserLoginComponent } ,
{ path: 'register-partner', component: PartnerRegisterComponent },
{path: 'moviedetail', component: MoviedetailsFormComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

export const routingComponents = [ LandingPageComponent, UserRegisterComponent ,
  UserLoginComponent, PartnerRegisterComponent, HomePageComponent];

