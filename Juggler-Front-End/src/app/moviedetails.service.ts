import { Injectable } from "@angular/core";
import { Movie } from "./movie";
import { MoviedetailsFormComponent } from "./moviedetails-form/moviedetails-form.component";
import { MovieDisplay } from "./MovieDisplay";

@Injectable({
  providedIn: "root"
})
export class MovieDetailsService {
  public one: MoviedetailsFormComponent;
  public data: MovieDisplay;
  constructor() {
    console.log(this.data);
  }
  send(movie: MovieDisplay) {
    this.data = movie;
  }
  receive() {
    console.log("receive" + this.data.movieName);
    return this.data;
  }
}