import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import { Theatre } from '../theatre';
import { TheatreService } from '../theatre.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-theatre-registration',
  templateUrl: './theatre-registration.component.html',
  styleUrls: ['./theatre-registration.component.scss']
})
export class TheatreRegistrationComponent implements OnInit {

  theatre = new Theatre();

  theatre_Name = new FormControl('', [
    Validators.required
  ]);
  theatre_LicenseNo = new FormControl('', [
    Validators.required
  ]);
  theatre_City = new FormControl('', [
    Validators.required
  ]);
  theatre_Location = new FormControl('', [
    Validators.required
  ]);
  number_OfSeats = new FormControl('', [
    Validators.required
  ]);
  constructor(private theatreService: TheatreService, private router: Router) { }
  onSubmit() {
    // this.theatre.theatreName = localStorage.getItem('currentUser').replace('\"', '').replace('\"', '');
    this.theatre.theatreName = this.theatre_Name.value;
    this.theatre.theatreLicenseNo = this.theatre_LicenseNo.value;
    this.theatre.theatreCity = this.theatre_City.value;
    this.theatre.theatreLocation = this.theatre_Location.value;
    this.theatre.numberOfSeats = this.number_OfSeats.value;
    console.log(this.theatre.theatreName);
    console.log(this.theatre);
    this.theatreService
      .saveTheatre(this.theatre)
      .subscribe(res => console.log('Saved theatre'));
    this.router.navigate(['/login-partner']);
  }
  ngOnInit() {
  }


}
