import { Component, OnInit } from '@angular/core';
import { RecommendationService} from '../recommendation.service';
import {  Movie } from "../movie-details";

@Component({
  selector: 'app-recommendation',
  templateUrl: './recommendation.component.html',
  styleUrls: ['./recommendation.component.scss']
})
export class RecommendationComponent implements OnInit {

  recommended_movies: any;
  email;
  genres = [];
  moviedetails = new Movie('','','','','');

  

 constructor(private recommendation:RecommendationService) { }

  ngOnInit() {
    if (localStorage.getItem("currentUserEmail") != null) {
      this.email = localStorage.getItem("currentUserEmail");
      this.recommendation.getLanguageGenreBasedMovies(this.email).subscribe(fullList => {
        this.recommended_movies = fullList;
        console.log("inside ngOnInit getRecommendationList");
      });
}
}
}
