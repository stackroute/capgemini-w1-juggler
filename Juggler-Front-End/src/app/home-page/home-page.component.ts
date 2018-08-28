import { Component, OnInit } from '@angular/core';
import { SearchDataService } from '../search-data.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  movies = [{'movieTitle': 'Gold', 'movieposter': 'https://assetscdn.paytm.com/images/cinema/MovieIcons/Gold-web-poster-updated.jpg'},
  {'movieTitle': 'Geeta Govindam', 'movieposter': 'https://assetscdn.paytm.com/images/cinema/MovieIcons/Geetha-Govindam-web-poster.jpg'},
  // tslint:disable-next-line:max-line-length
  {'movieTitle': 'Happy Phir bhag jayeghi', 'movieposter': 'https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/images/cinema/Happy-phirr-bhag-jayegi-web-poster-214c1486-e7e3-4f94-bd64-bbeaadf6f3ff.jpg'},
  {'movieTitle': 'Mile22', 'movieposter': 'https://assetscdn1.paytm.com/images/catalog/view_item/195582/1535023771411.jpg'}];

  // movies: any = [];
 city: string;
 addedList;
 movieObject = { 'cityId' : 1, 'cityName' : 'bangalore'};
  constructor(private cityService: SearchDataService) { }

  ngOnInit() {}
  // searchMovies(city: string) {
  //   this.cityService.searchMovie(city).subscribe(fullList => this.movies = fullList);
  //   console.log(this.movies);
  // }
  getMovieInfo(movie) {
    console.log(movie);
  }
  onAdd(movieObject) {
    this.cityService.getByMovieCity(movieObject.subscribe(data => this.addedList = data));
    return this.addedList;
  }
}
