import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Theatre } from "./theatre";

@Injectable({
  providedIn: "root"
})
export class TheatreService {
  private _url = "http://10.20.1.15.193:9071";
  constructor(private http: HttpClient) {}

  saveTheatre(theatre: Theatre, email: string): Observable<Theatre> {
    return this.http.post<Theatre>(
      this._url + "/api/v1/theatre/?email=" + email,
      theatre
    );
  }
}
