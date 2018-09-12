import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
@Injectable()
export class UserService {
  private _url = 'http://localhost:8040';
  constructor(private http: HttpClient) {}

  saveUser(user: User): Observable<User> {
   return this.http.post<User>(this._url + '/api/v1/userProfile/regestration', user);
  }


}
