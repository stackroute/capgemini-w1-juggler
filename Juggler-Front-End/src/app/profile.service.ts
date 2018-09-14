import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private _url = 'http://172.23.239.112:8020';
  constructor(private http: HttpClient) {}
}
