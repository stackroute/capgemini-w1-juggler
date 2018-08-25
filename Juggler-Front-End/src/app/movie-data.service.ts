import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movie } from './movie';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieDataService {
  private url2 = 'http://123.12.12.12.:8010/api/v1/movie/';
  constructor(private http: HttpClient) { }

  setDistributorMovies(id) {
    return this.http.get('http://localhost.:8010/api/v1/movie/' + id);
  }
  addMovie(movie: Movie): Observable<Movie> {
    return this.http.post<Movie>(this.url2 , movie);
  }
}
