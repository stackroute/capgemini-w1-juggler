import { Component, OnInit,ViewChild, AfterViewInit } from '@angular/core';
import { SearchDataService } from '../search-data.service';
import { AuthenticationService } from '../authentication.service';
import { DialogComponentComponent } from '../landing-page/dialog-component/dialog-component.component';
import { SharingDataService } from '../sharing-data.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  
  name:string
  citydetails: any;
  flag:boolean;
  userLogged:boolean;
  citySelected:boolean=false;
  constructor(private cityService: SearchDataService,private router: Router,private authenticationService: AuthenticationService, private sharingDataService:SharingDataService) { }
 
  ngOnInit() {
    
    

    if(localStorage.getItem("currentUser")!== null)
   {
     this.flag = true;
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
  displayCityName(){
    this.citySelected=true;
    this.name=this.sharingDataService.sendCityName();
    //location.reload();
  }

 
  searchMovies(Movie: string) {
  
    console.log(Movie);
  this.sharingDataService.receiveMovieName(Movie);
    
  this.router.navigate(['home',Movie]);
}
}
