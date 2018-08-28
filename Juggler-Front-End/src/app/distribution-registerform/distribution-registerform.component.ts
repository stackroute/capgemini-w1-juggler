import { MovieDataService } from './../movie-data.service';
import { Movie } from './../movie';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-distribution-registerform',
  templateUrl: './distribution-registerform.component.html',
  styleUrls: ['./distribution-registerform.component.scss']
})
export class DistributionRegisterformComponent implements OnInit {
  movie = new Movie();
  constructor(private cardservice:MovieDataService) { }
  ngOnInit() {
  }
    onSubmit() {

      // this.theatre.theatreName = localStorage.getItem('currentUser').replace('\"', '').replace('\"', '');
      console.log(this.movie.movieName);
      console.log(this.movie);
      this.cardservice
        .addMovie(this.movie)
        .subscribe(res => console.log('Saved theatre'));
    }
  }



