import { Component, OnInit } from '@angular/core';
import { SearchDataService } from '../search-data.service';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  citydetails: any;
  flag:boolean;
  constructor(private cityService: SearchDataService, private authenticationService: AuthenticationService) { }

  ngOnInit() {
    if(localStorage.getItem("currentUser")!== null)
    this.flag = true;
    else
    this.flag = false;
      }
      logout()
      {
      this.authenticationService.logout();
      this.flag= false;
      location.reload();
      
      }
  // searchCity(city: string) {
  //   this.cityService.getByMovieCity(city).subscribe(data => this.citydetails = data);
  // }
}
