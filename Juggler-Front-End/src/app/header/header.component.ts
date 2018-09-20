import { Component, OnInit } from '@angular/core';
import { SearchDataService } from '../search-data.service';
import { AuthenticationService } from '../authentication.service';
import { Router, ActivatedRoute, ParamMap } from "@angular/router";
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  citydetails: any;
  flag:boolean;
  userLogged:boolean;
  city: string;
;
  constructor(private cityService: SearchDataService, private authenticationService: AuthenticationService, private router: ActivatedRoute) { }

  ngOnInit() {
    
    

    if(localStorage.getItem("currentUser")!== null)
   {this.flag = true;
    this.userLogged =false;
  }
    else
   {this.flag = false;
    this.userLogged =true;
      }
      
    }
      logout()
      {
      this.authenticationService.logout();
      this.flag= false;
      location.reload();
      
      }

      // for navbar
      navbarOpen = false;

  toggleNavbar() {
    this.navbarOpen = !this.navbarOpen;
  }
  // searchCity(city: string) {
  //   this.cityService.getByMovieCity(city).subscribe(data => this.citydetails = data);
  // }
}
