import { Component, OnInit, Input } from '@angular/core';
import { ScreeningDetails } from '../screening-details';
import {
  FormControl,
  Validators,
  FormGroup,
  FormBuilder
} from '@angular/forms';
import { MovieScreeningService } from '../movie-screening.service';
import { Router, ParamMap, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-movie-screening',
  templateUrl: './movie-screening.component.html',
  styleUrls: ['./movie-screening.component.scss']
})
export class MovieScreeningComponent implements OnInit {
  title: string;
  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;

  tName: string;
  movies = [];
  screening = new ScreeningDetails();
  
  constructor(
    private screeningService: MovieScreeningService,
    private _formBuilder: FormBuilder,
    private route: Router,
    private router: ActivatedRoute
  ) {}

  onSubmit(mve) {
    this.screening.showNumbers = this.f.show_Numbers.value;
    this.screening.showTimings = this.f.show_Timings.value;
    this.screening.weekdays_Price = this.f.weekdays_Price.value;
    this.screening.weekends_Price = this.f.weekends_Price.value;
    this.screening.id = mve.id;
    this.screening.movieName = mve.movieName;
    this.screening.moviePoster = mve.moviePoster;
    this.screening.movieReleaseDate = mve.movieReleaseDate;
    this.screening.movieDuration = mve.movieDuration;
    this.screening.synopsis = mve.synopsis;
    this.screening.format = mve.format;
    this.screening.movieGenres = mve.movieGenres;
    this.screening.languages = mve.languages;
    this.screening.actors = mve.actors;
    this.screening.actress = mve.actress;
    this.screening.directors = mve.directors;
    console.log(this.screening.movieName);
    console.log(this.screening);
    console.log(this.tName);
    console.log(this.screening.moviePoster);
    this.screeningService
      .saveScreening(this.screening, this.tName)
      .subscribe(res => console.log('Saved screening details'));
      // this.route.navigate(['/login-partner']);
  }

  getMovie(title: string) {
    this.screeningService.getMovies(title).then(re => (this.movies = re));
  }
  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      show_Numbers: ['', Validators.required],
      show_Timings: ['', Validators.required],
      weekdays_Price: ['', Validators.required],
      weekends_Price: ['', Validators.required]
    });
    this.router.paramMap.subscribe((params: ParamMap) => {
      console.log(params.get('theatreName'));
      const ttName = (params.get('theatreName'));
      console.log(ttName);
      this.tName = ttName;
      console.log(this.tName);
    });

  }
  get f() {
    return this.firstFormGroup.controls;
  }
  // get f1() {
  //   return this.secondFormGroup.controls;
  // }

}
