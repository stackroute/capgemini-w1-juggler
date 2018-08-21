import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PartnerRegisterComponent } from './partner-register/partner-register.component';
import { UserRegisterComponent } from './user-register/user-register.component';

const routes: Routes = [{ path: 'register-user', component: UserRegisterComponent } ,
{ path: 'register-partner', component: PartnerRegisterComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [ UserRegisterComponent , PartnerRegisterComponent ];

