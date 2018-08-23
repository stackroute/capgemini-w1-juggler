import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MovieDataService {

  constructor(private http: HttpClient) { }
  getMovieById(id) {
    return this.http.get('http://123.12.12.12.:8010/api/v1/movie/' + id);
  }
}
