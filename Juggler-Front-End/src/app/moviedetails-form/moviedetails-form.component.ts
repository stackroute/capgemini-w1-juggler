import { Component, OnInit } from '@angular/core';
import { MovieDataService } from '../movie-data.service';

@Component({
  selector: 'app-moviedetails-form',
  templateUrl: './moviedetails-form.component.html',
  styleUrls: ['./moviedetails-form.component.scss']
})
export class MoviedetailsFormComponent implements OnInit {
  movie: any;
  constructor(private movieService: MovieDataService) { }

  ngOnInit() {
    this.movieService.getMovie().subscribe(data => {
    this.movie = data;
    });
  }
}

