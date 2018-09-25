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
  url = "http://172.23.239.49:9079/api/v1/ticket/layout";
  url1 = "http://172.23.239.49:9079/api/v1/ticket/update";
  constructor(private http: HttpClient) {}

  getseatDetails(): Observable<Layout[]> {
    console.log("inside service class");
    return this.http
      .get<Layout[]>(this.url + "/pvr2219:00bangalore")
      .pipe(map(res => (this.data = res)));
  }
  getData(showId, blockedSeats) {
    return this.http.put<any>(this.url1 + "/" + showId, blockedSeats);
  }

  sendseatDetails() {}
}
