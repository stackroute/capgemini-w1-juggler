import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Movie } from './movie';

@Injectable({
 providedIn: 'root'
})

export class SearchDataService {

 private city_string: string;

 constructor(private http: HttpClient, private router: Router) { }

 getAllMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>('http://localhost:8060/api/v1/movies');
 }

 getByMovieCity(city: string): Observable<any> {
   this.city_string = city;
   return this.http.get('http://localhost:8060/api/v1/city/' + this.city_string)
      .pipe(map((response: Response) => {
        return response.json();
      }));
 }

 getByMovieName(name) {
   return this.http.get('http://172.00.00.00:8060/api/v1/movie/' + name);
 }

}

