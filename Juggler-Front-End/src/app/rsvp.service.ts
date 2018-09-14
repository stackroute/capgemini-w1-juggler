import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Event} from "./event";
@Injectable({ 
  providedIn: 'root'
})
export class RsvpService {
  private _url = 'http://localhost:9094';
  constructor(private http: HttpClient) {}

  addEvent(event: Event): Observable<Event> {
   return this.http.post<Event>(this._url + '/api/v1/event', event);
  }
}
