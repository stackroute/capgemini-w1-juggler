import { Injectable } from "@angular/core";
import { Movie } from "./movie";
import { MoviedetailsFormComponent } from "./moviedetails-form/moviedetails-form.component";

@Injectable({
  providedIn: "root"
})
export class MovieDetailsService {
  public one: MoviedetailsFormComponent;
  public data: Movie;
  constructor() {
    console.log(this.data);
  }
  send(movie: Movie) {
    this.data = movie;
  }
  receive() {
    console.log("receive" + this.data.movieName);
    return this.data;
  }
}