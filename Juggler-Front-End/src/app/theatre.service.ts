import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Theatre } from "./theatre";

@Injectable({
  providedIn: "root"
})
export class TheatreService {
  // private _url = "http://:13.233.63.78:9071";
  private _url = "http://13.127.156.198:9071";
  constructor(private http: HttpClient) {}

  saveTheatre(theatre: Theatre, email: string): Observable<Theatre> {
    return this.http.post<Theatre>(
      this._url + "/api/v1/theatre/?email=" + email,
      theatre
    );
  }
}
