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
  search_result1;
  city: string;
  movie:string;
  selectedName;
  selectedMovie: Movie;
  nameOfMovie: string;
  movieDataList;
  listMovie = [];
  data: Movie;
  test: any = 2;
  onResize(event) {
    const element = event.target.innerWidth;
    console.log(element);
    if (element < 950) {
      this.test = 2;
    }

    if (element > 950) {
      this.test = 3;
    }

    if (element < 750) {
      this.test = 1;
    }
  }


   constructor(private cityService: SearchDataService, private movieDetailsService: MovieDetailsService , private route: Router, private router: ActivatedRoute) { }
   searchMovies(Name) {
    //  console.log(this.city);
    this.movie=Name;
    this.cityService.searchMovie(this.movie)
    .subscribe(data => {
      this.search_result1 = data;
    });
      console.log(this.search_result1);
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


