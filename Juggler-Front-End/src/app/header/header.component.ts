import { Component, OnInit } from '@angular/core';
import { SearchDataService } from '../search-data.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  citydetails: any;
  constructor(private cityService: SearchDataService) { }

  ngOnInit() {
  }
  // searchCity(city: string) {
  //   this.cityService.getByMovieCity(city).subscribe(data => this.citydetails = data);
  // }
}
