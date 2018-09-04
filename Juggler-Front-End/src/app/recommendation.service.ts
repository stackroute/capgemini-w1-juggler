import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {Movie} from './movie-details';
import {Observable} from 'rxjs';
  

@Injectable({
  providedIn: 'root'
})
export class RecommendationService {

  private recommended_url = "http://localhost:8050/recommendation/api/v1/";
  private genrebasedmovies_url = "http://localhost:8050/api/v1/getGenreBasedMoviesForUser/";
  private languagebasedmovies_url = "http://localhost:8050/api/v1/getLanguageBasedMoviesForUser/";
  private languagegenrebased_url = "http://localhost:8050/api/v1/getGenreLanguageBasedMoviesForUser/";
  

  constructor(private http:HttpClient) { }

  getGenreBasedMovies(emailId): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.genrebasedmovies_url + '/' + emailId);
  }

  getLanguageBased(emailId): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.languagebasedmovies_url+ '/' + emailId);
  }
 getLanguageGenreBasedMovies(emailId):Observable<Movie[]> {
   return this.http.get<Movie[]>(this.languagegenrebased_url+ '/' + emailId);
 }
}
