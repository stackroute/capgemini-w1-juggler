import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import { MovieDataService } from '../movie-data.service';
import { Movie } from '../movie';

@Component({
  selector: 'app-distribution-registerform',
  templateUrl: './distribution-registerform.component.html',
  styleUrls: ['./distribution-registerform.component.scss']
})
export class DistributionRegisterFormComponent implements OnInit {

  movie = new Movie();

  movie_name = new FormControl('', [
    Validators.required
  ]);
  movie_poster = new FormControl('', [
    Validators.required
  ]);
  movie_Synopsis = new FormControl('', [
    Validators.required
  ]);
  _format = new FormControl('', [
    Validators.required
  ]);
  movie_Releasedate = new FormControl('', [
    Validators.required
  ]);
  movie_Duration = new FormControl('', [
    Validators.required
  ]);
  _actor = new FormControl('', [
    Validators.required
  ]);
  _actres = new FormControl('', [
    Validators.required
  ]);
  _directors = new FormControl('', [
    Validators.required
  ]);
  _languages = new FormControl('', [
    Validators.required
  ]);
  movie_Genres = new FormControl('', [
    Validators.required
  ]);
  constructor(private cardservice: MovieDataService) { }

  onSubmit() {
    this.movie.movieName = this.movie_name.value;
    this.movie.movieposter = this.movie_poster.value;
    this.movie.synopsis = this.movie_Synopsis.value;
    this.movie.format = this._format.value;
    this.movie.movieReleaseDate = this.movie_Releasedate.value;
    this.movie.movieDuration = this.movie_Duration.value;
    this.movie.actor = this._actor.value;
    this.movie.actres = this._actres.value;
    this.movie.directors = this._directors.value;
    this.movie.languages = this._languages.value;
    this.movie.movieGenres = this.movie_Genres.value;
      // this.theatre.theatreName = localStorage.getItem('currentUser').replace('\"', '').replace('\"', '');
      console.log(this.movie.movieName);
      console.log(this.movie);
      this.cardservice
        .addMovie(this.movie)
        .subscribe(res => console.log('Saved theatre'));
  }
  ngOnInit() {
  }

}



