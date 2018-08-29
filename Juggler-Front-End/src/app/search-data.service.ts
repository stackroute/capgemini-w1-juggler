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
 private movie_string: string;
 private url = 'http://localhost:8060/api/v1/movie';
 private url3 = 'http://localhost:8060/api/v1/city';

 constructor(private http: HttpClient, private router: Router) { }

//  getAllMovies(): Observable<Movie[]> {
//     return this.http.get<Movie[]>('http://localhost:8060/api/v1/movies');
//  }

 getByMovieCity(city: string) {
  //  return this.http.get('http://localhost:8060/api/v1/city' + '/' + city);
   return this.http.get('http://localhost:8060/api/v1/city/' + this.city_string)
      .pipe(map((response: Response) => {
        return response.json();
      }));
}
  searchMoviebycity(city: string) {
    this.city_string = city;
    console.log(this.city_string + '11');
    return fetch (this.url3 + '/' + this.city_string)
              .then(response => response.json());
  }

  searchMovie(movie: string) {
   this.movie_string = movie;
   return this.http.get(this.url + '/' + this.movie_string);
  }
//  searchMovie(city: string) {

//   return this.http.get('http://localhost:8060/api/v1/city' + '/' + city);
// }

 getByMovieName(name) {
   return this.http.get('http://localhost:8060/api/v1/movie/' + name);
 }

}


