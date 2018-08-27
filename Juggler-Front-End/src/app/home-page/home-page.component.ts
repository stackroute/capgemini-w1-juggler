import { Component, OnInit } from '@angular/core';
import { SearchDataService } from '../search-data.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  movies = [];
  constructor(private cityService: SearchDataService) { }

  ngOnInit() {
    this.cityService.getAllMovies().subscribe(fullList => this.movies = fullList);
  }
  getMovieInfo(movie) {
    console.log(movie);
  }
}
