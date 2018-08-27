import { Component, OnInit } from '@angular/core';
import { Theatre } from '../theatre';
import { TheatreService } from '../theatre.service';
@Component({
  selector: 'app-theatre-registration',
  templateUrl: './theatre-registration.component.html',
  styleUrls: ['./theatre-registration.component.scss']
})
export class TheatreRegistrationComponent implements OnInit {

  theatre = new Theatre();
  constructor(private theatreService: TheatreService) { }
  onSubmit() {

    // this.theatre.theatreName = localStorage.getItem('currentUser').replace('\"', '').replace('\"', '');
    console.log(this.theatre.theatreName);
    console.log(this.theatre);
    this.theatreService
      .saveTheatre(this.theatre)
      .subscribe(res => console.log('Saved theatre'));
  }
  ngOnInit() {
  }


}
