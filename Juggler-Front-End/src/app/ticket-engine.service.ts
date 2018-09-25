import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs/operators";
import { Layout } from "./layout";
import { Blocking } from "./blocking";

@Injectable({
  providedIn: "root"
})
export class TicketEngineService {
  data;
  result;
  private url = "http://172.23.239.49:9079/api/v1/ticket/layout";
  private url_1 = "http://172.23.239.49:9079/api/v1/ticket/update";
  // url2 = "http://172.23.239.49:9079/api/v1/ticket/update/Asian2709:45Hyderabad";
  constructor(private http: HttpClient) {}

  getseatDetails(showId): Observable<Layout[]> {
    console.log("inside service class");
    return this.http
      .get<Layout[]>(this.url + "/" + showId)
      .pipe(map(res => (this.data = res)));
  }
  getData(showId,blockedSeatsArray) {
    console.log("inside getData call");
    return this.http.put(this.url_1 + "/" + showId,blockedSeatsArray);
    // return this.http.get(this.url2);
  }
}
