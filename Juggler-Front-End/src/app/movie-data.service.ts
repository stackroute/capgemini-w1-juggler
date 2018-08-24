import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MovieDataService {

  constructor(private http: HttpClient) { }

  setDistributorMovies(id) {
    return this.http.get('http://localhost.:8010/api/v1/movie/' + id);
  }
}
