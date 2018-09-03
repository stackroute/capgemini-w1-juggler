import { Component, OnInit } from '@angular/core';
import { SearchDataService } from '../search-data.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  addedList;
  search_result = [];
  city: any;
   constructor(private cityService: SearchDataService, private route: Router, private router: ActivatedRoute) { }
   searchMovies() {
    //  console.log(this.city);
     this.cityService.searchMoviebycity(this.city)
     .then(re => this.search_result = re);
       console.log(this.search_result);
   }
   ngOnInit() {
    this.router.paramMap.subscribe((params: ParamMap) => {
      // console.log(params.get('city'));
      const city = (params.get('city'));
      this.city = city;
      // console.log(this.city);
    });
   }

}

