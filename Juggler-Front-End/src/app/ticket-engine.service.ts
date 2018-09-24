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
  result;
  //   private url = "http://172.23.239.49:9079/api/v1/ticket/layout";

  //   constructor(private http: HttpClient) {}

  //   getseatDetails(): Observable<Layout[]> {
  //     console.log("inside service class");
  //     return this.http
  //       .get<Layout[]>(this.url + "/pvr2219:00bangalore")
  //       .pipe(map(res => (this.data = res)));
  //   }
  //   sendseatDetails() {}
  // }
  private url = "http://172.23.239.49:9079/api/v1/ticket/layout";
  private url_1 = "http://172.23.239.49:9079/api/v1/ticket/update";

  constructor(private http: HttpClient) {}

  getseatDetails(showId): Observable<Layout[]> {
    console.log("inside service class");
    return this.http
      .get<Layout[]>(this.url + "/" + showId)
      .pipe(map(res => (this.data = res)));
  }
  sendseatDetails(showId, blockedSeatsArray) {
    return this.http.post<Blocking>(
      this.url_1 + "/" + showId,
      blockedSeatsArray
    );
  }
}
