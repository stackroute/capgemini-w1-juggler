import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MovieDataService } from '../movie-data.service';
import { Movie } from '../movie';
import { Router } from '@angular/router';
// import { MatFileUploadModule } from 'angular-material-fileupload';


@Component({
  selector: 'app-distribution-registerform',
  templateUrl: './distribution-registerform.component.html',
  styleUrls: ['./distribution-registerform.component.scss']
})
export class DistributionRegisterFormComponent implements OnInit {
  constructor(
    private cardservice: MovieDataService,
    private _formBuilder: FormBuilder,
    private route: Router
  ) {}

  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
 
  options: string[] = ['Bengali', 'English', 'Gujarati', 'Hindi', 'Kannada', 'Marathi', 'Malyalam', 'Telugu', 'Tamil'];

  options1: string[] = ['Comedy', 'Crime', 'Historical period', ' Horror', ' Legal', 'Melodrama', 'Military', 'Romantic', 'Teen'];


  // hide = true;
  movie = new Movie();

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      movie_name: ['', Validators.required],
      movie_poster: ['', Validators.required],
      _format: ['', Validators.required],
      movie_Releasedate: ['', Validators.required],
      movie_Genres: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      _actor: ['', Validators.required],
      _actress: ['', Validators.required],
      _directors: ['', Validators.required],
      _languages: ['', Validators.required],
      movie_Duration: ['', Validators.required],
      movie_Synopsis: ['', Validators.required]
    });
  }
  get f() {
    return this.firstFormGroup.controls;
  }
  get f1() {
    return this.secondFormGroup.controls;
  }

  addMovie() {
  console.log(this.f.movie_Releasedate.value.getYear());
    this.movie.movieName = this.f.movie_name.value;
    this.movie.moviePoster = this.f.movie_poster.value;
    this.movie.format = this.f._format.value;
    this.movie.movieReleaseDate = 
      this.f.movie_Releasedate.value.getDate()+"/"+
      this.f.movie_Releasedate.value.getMonth()+"/"+
      this.f.movie_Releasedate.value.getUTCFullYear();
    this.movie.movieGenres = this.f.movie_Genres.value;
    this.movie.actors = this.f1._actor.value;
    this.movie.synopsis = this.f1.movie_Synopsis.value;
    this.movie.movieDuration = this.f1.movie_Duration.value;
    this.movie.actress = this.f1._actress.value;
    this.movie.directors = this.f1._directors.value;
    this.movie.languages = this.f1._languages.value;
    console.log(this.movie.movieName);
    console.log(this.movie);
    console.log(this.movie.movieReleaseDate);
    console.log(this.movie.moviePoster);
    this.cardservice
      .addMovie(this.movie)
      .subscribe(res => console.log('Saved theatre'));
    this.route.navigate(['/login-partner']);
  }
}
