import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import "rxjs/add/operator/map";
import { map } from "rxjs/operators";
import {Event} from "./event";
@Injectable({ 
  providedIn: 'root'
})
export class RsvpService {
  data: any;
  private _url = "http://13.232.202.193:9075/api/v1/event";
  movies_url = "http://13.232.202.193:9075/api/v1/event/get/?emailId=";
  //private _url = "http://172.23.239.115:9094;
  //event:Object;
  constructor(private http: HttpClient) {}

  // saveEvent(event): Observable<Event> {
  //  return this.http.post<Event>(this._url, event);
  //  //return this.http.post<Event>(this._url + "/api/v1/event", event);
  // }
  saveEvent(event: Event): Observable<Event> {
    return this.http.post<Event>(this._url, event);
  }

  // getEvents(email): Observable<Event> {
  //   console.log("get event");
  //   return this.http.get<>(this.movies_url + '/' + "?emailid= email");
  // }

  searchEvent(email: string) {
    console.log(email + " in service");
    // http://localhost:9094/api/v1/event/get/?emailId=zyx@gmail.com
    console.log("data is " + this.data);
    return this.http.get(this.movies_url + email).map(res => (this.data = res));
  }
}


 
