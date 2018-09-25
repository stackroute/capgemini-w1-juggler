import { Blocking } from "./blocking";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs/operators";
import { Layout } from "./layout";

@Injectable({
  providedIn: "root"
})
export class TicketEngineService {
  data;
  url = "http://10.20.1.15:9079/api/v1/ticket/layout";
  url1 = "http://10.20.1.15:9079/api/v1/ticket/update";
  constructor(private http: HttpClient) {}

  getseatDetails(showId): Observable<Layout[]> {
    console.log("inside service class");
    return this.http
      .get<Layout[]>(this.url + "/" + showId)
      .pipe(map(res => (this.data = res)));
  }
  sendseatDetails(showId, blockedSeatsArray) {
    return this.http.post<Blocking>(
      this.url1 + "/" + showId,
      blockedSeatsArray
    );
  }
  getData(showId, blockedSeats) {
    return this.http.put<any>(this.url1 + "/" + showId, blockedSeats);
  }
}
