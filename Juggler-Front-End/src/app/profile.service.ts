import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private _url = 'http://10.20.1.15:9073';
  constructor(private http: HttpClient) {}
}
