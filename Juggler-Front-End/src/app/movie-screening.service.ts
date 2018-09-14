import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { ScreeningDetails } from "./screening-details";
import { ActivatedRoute, ParamMap } from "@angular/router";

@Injectable({
  providedIn: "root"
})
export class MovieScreeningService {
  private _url = "http://172.23.239.112:8030";
  constructor(private http: HttpClient, private router: ActivatedRoute) {}

  getMovies(title: string) {
    return fetch(
      "http://172.23.239.112:8010/api/v1/getbytitle/movie/?movieTitle=" + title
    ).then(response => response.json());
  }

  saveScreening(
    movieScreening: ScreeningDetails,
    tName: string
  ): Observable<ScreeningDetails> {
    return this.http.put<ScreeningDetails>(
      this._url + "/api/v1/update/?email=" + tName,
      movieScreening
    );
  }
}
