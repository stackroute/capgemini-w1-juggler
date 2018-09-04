import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ScreeningDetails } from './screening-details';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Movie } from './movie';

@Injectable({
  providedIn: 'root'
})
export class MovieScreeningService {
  // public tName;
  private _url = 'http://localhost:8030';
  constructor(private http: HttpClient, private router: ActivatedRoute) {}

  getMovies(title: string) {
    return fetch(
      'http://localhost:8010/api/v1/getbytitle/movie/?movieTitle=' + title
    ).then(response => response.json());
  }

  // getWhishList(): Observable<Movie[]> {
  //   const baseUrl = 'http://localhost:8090/api/v1/movieservice/movies';
  //   return this.http.get<Movie[]>(baseUrl);
  // }

  // addMovie(
  //   movieScreening: ScreeningDetails, tName: string
  // ): Observable<ScreeningDetails> {
  //   return this.http.put<ScreeningDetails>(
  //     this._url + '/api/v1/update/' + tName  ,
  //     movieScreening
  //   );
  // }
  
  saveScreening(
    movieScreening: ScreeningDetails, tName: string
  ): Observable<ScreeningDetails> {
    return this.http.put<ScreeningDetails>(
      this._url + '/api/v1/update/' + tName  ,
      movieScreening
    );
  }
}
