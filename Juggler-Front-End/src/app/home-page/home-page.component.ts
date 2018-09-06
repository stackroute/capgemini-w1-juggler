import { Component, OnInit } from '@angular/core';
import { SearchDataService } from '../search-data.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Movie } from "../movie";
import { map } from 'rxjs/operators';
import { MovieDetailsService } from '../moviedetails.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  search;
  // addedList;
  search_result;
  city: string;
  selectedName;
  selectedMovie: Movie;
  nameOfMovie: string;
  movieDataList;
  listMovie = [];
  data: Movie;
   constructor(private cityService: SearchDataService, private movieDetailsService: MovieDetailsService , private route: Router, private router: ActivatedRoute) { }
   searchMovies(cityName) {
    //  console.log(this.city);
    this.cityService.getByMovieName(cityName)
    .subscribe(data => {
      this.search_result = data
    });
      //  console.log(this.search_result);
   }
   ngOnInit() {
      this.router.paramMap.subscribe((params: ParamMap) => {
      // console.log(params.get('city'));
      const city = (params.get('city'));
      this.city = city;
      // console.log(this.city);
      this.cityService.searchMoviebycity(this.city)
              .subscribe(data => {
                this.search_result = data["movieList"];
              });
      console.log(this.search_result);
    });
   }
   getMovieInfo(movieDetail) {
    
    this.selectedMovie = movieDetail;
    this.movieDetailsService.send(this.selectedMovie);
    //console.log( this.selectedMovie.movieName);
  }
}


