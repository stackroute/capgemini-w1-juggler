import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Movie } from './movie';
import { City } from './City';

@Injectable({
 providedIn: 'root'
})

export class SearchDataService {
  data: any;
  private city_string: string;
  private movie_string: string;
  private url = 'http://localhost:8060/api/v1/movie';
  private url3 = 'http://localhost:8060/api/v1/city';
  
  constructor(private http: HttpClient, private router: Router) { }
  
  //
  
  // getByMovieCity(city: string) {
  //  //  return this.http.get('http://localhost:8060/api/v1/city' + '/' + city);
  //   return this.http.get('http://localhost:8060/api/v1/city' + '/' + city)
  //      .pipe(map((response: Response) => {
  //        return response.json;
  //      }));
  // }
   searchMoviebycity(city: string) {
   
      return this.http.get(this.url3 + '/' + city)
      .pipe( map(res => this.data = res));
   }
  
   searchMovie(movie: string) {
   
    return this.http.get(this.url + '/' + movie)
    .pipe( map(res => this.data = res));
   }

}


