import { Component, OnInit } from '@angular/core';
import { SearchDataService } from '../search-data.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  
  addedList;
  search_result = [];
  city: any;
   constructor(private cityService: SearchDataService) { }
   searchMovies() {
     console.log(this.city);
     this.cityService.searchMoviebycity(this.city)
     .then(re => this.search_result = re);
       console.log(this.search_result);
   }
   ngOnInit() {}

}

