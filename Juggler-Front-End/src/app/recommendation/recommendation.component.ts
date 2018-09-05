import { Component, OnInit } from '@angular/core';
import { RecommendationService} from '../recommendation.service';
import {  Movie } from "../movieDetails";
@Component({
  selector: 'app-recommendation',
  templateUrl: './recommendation.component.html',
  styleUrls: ['./recommendation.component.scss']
})
export class RecommendationComponent implements OnInit {
  recommended_Movies: any;
  email;
  genres = [];
 
   constructor(private recommendation:RecommendationService) { }  ngOnInit() {
    // if (localStorage.getItem("currentUserEmail") != null) {
      // this.email = localStorage.getItem("currentUserEmail");
      this.getGenreBasedMovies();
 }
 getGenreBasedMovies()
{      console.log("inside ngOnInit getRecommendationList");
      this.email="jyothi@email.com";
      this.recommendation.getGenreBasedMovies(this.email).subscribe(fullList => {
        this.recommended_Movies = fullList;
        console.log("inside ngOnInit getRecommendationList");
      });
    }
    getLanguageBased()
{      console.log("inside ngOnInit getRecommendationList");
      this.email="jyothi@email.com";
      this.recommendation.getLanguageBased(this.email).subscribe(fullList => {
        this.recommended_Movies = fullList;
        console.log("inside ngOnInit getRecommendationList");
      });
    }
    getLanguageGenreBasedMovies()
{      console.log("inside ngOnInit getRecommendationList");
      this.email="jyothi@email.com";
      this.recommendation.getLanguageGenreBasedMovies(this.email).subscribe(fullList => {
        this.recommended_Movies = fullList;
        console.log("inside ngOnInit getRecommendationList");
      });
    }
 }


