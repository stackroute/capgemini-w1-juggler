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
  private url = "http://172.23.239.47:9079/api/v1/ticket/layout";
  constructor(private http: HttpClient) {}

  getseatDetails(): Observable<Layout[]> {
    console.log("inside service class");
    return this.http
      .get<Layout[]>(this.url + "/pvr2218:00bangalore")
      .pipe(map(res => (this.data = res)));
  }
  sendseatDetails() {}
}
