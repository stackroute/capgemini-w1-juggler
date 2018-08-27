import { Component, OnInit } from '@angular/core';
import { SearchDataService } from '../search-data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.scss']
})
export class LandingPageComponent implements OnInit {
  movies = [];
  constructor(private cityService: SearchDataService, private router: Router) { }

  ngOnInit() {
    this.cityService.getAllMovies().subscribe(fullList => this.movies = fullList);
  }
  getMovieInfo(movie) {
    this.router.navigate(['/moviedetail']);
  }
}

