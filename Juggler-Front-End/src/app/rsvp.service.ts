import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Event} from "./event";
@Injectable({ 
  providedIn: 'root'
})
export class RsvpService {
  private _url = "http://localhost:9094/api/v1/event";
  //private _url = "http://172.23.239.115:9094;
  event=new Event();
  constructor(private http: HttpClient) {}

  // saveEvent(event): Observable<Event> {
  //  return this.http.post<Event>(this._url, event);
  //  //return this.http.post<Event>(this._url + "/api/v1/event", event);
  // }
   saveEvent(event:Event): Observable<Event> {
    return this.http.post<Event>(
      this._url,
      event
    );
  }
}   


 
