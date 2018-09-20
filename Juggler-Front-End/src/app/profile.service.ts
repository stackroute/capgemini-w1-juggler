import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private _url = 'http://13.232.202.193:9073';
  constructor(private http: HttpClient) {}
}
