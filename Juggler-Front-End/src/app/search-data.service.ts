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

 private city_string: string;

 constructor(private http: HttpClient, private router: Router) { }

//  getAllMovies(): Observable<Movie[]> {
//     return this.http.get<Movie[]>('http://localhost:8060/api/v1/movies');
//  }
// private url3 = 'http://localhost:8060/api/v1/city/';
 getByMovieCity(city: string) {
  //  return this.http.get('http://localhost:8060/api/v1/city' + '/' + city);
   return this.http.get('http://localhost:8060/api/v1/city/' + this.city_string)
      .pipe(map((response: Response) => {
        return response.json();
      }));
}

 searchMovie(city: string) {

  return this.http.get('http://localhost:8060/api/v1/city' + '/' + city);
}

 getByMovieName(name) {
   return this.http.get('http://localhost:8060/api/v1/movie/' + name);
 }

}


