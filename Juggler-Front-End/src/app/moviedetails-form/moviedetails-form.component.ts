import { Component } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
@Component({
  selector: 'app-moviedetails-form',
  templateUrl: './moviedetails-form.component.html',
  styleUrls: ['./moviedetails-form.component.scss']
})
export class MoviedetailsFormComponent {

  constructor() { }
  // searchMovies() {
  //   this.movieService.searchMovie(this.movie).subscribe(data => {
  //     this.search_result = data['results'];
  //     // console.log(this.search_result);
  //   });
  // }
  
  // email = new FormControl('', [Validators.required, Validators.email]);

  // getErrorMessage() {
  //   return this.email.hasError('required') ? 'You must enter a value' :
  //       this.email.hasError('email') ? 'Not a valid email' :
  //           '';
  // }
}
