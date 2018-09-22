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
  private url = "http://10.20.1.15:9079/api/v1/ticket/allSeats";

  constructor(private http: HttpClient) {}

  getseatDetails(): Observable<Layout[]> {
    console.log("inside service class");
    return this.http
      .get<Layout[]>(this.url + "/pvr2219:00bangalore")
      .pipe(map(res => (this.data = res)));
  }
  sendseatDetails() {}
}
