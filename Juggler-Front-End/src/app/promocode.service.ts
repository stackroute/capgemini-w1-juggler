import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { map } from "rxjs/operators";
@Injectable({
  providedIn: "root"
})
export class PromocodeService {
  data: any;
  // private url = "http://172.23.239.47:9096/api/v1/promocodes";

  // private url1 = "http://172.23.239.47:9096/api/v1/promocode";
  private url = "http://localhost:9096/api/v1/promocodes";
  private url1 = "http://localhost:9096/api/v1/promocode";
  constructor(private http: HttpClient, private router: Router) {}

  
  getpromos() {
    return this.http.get(this.url).pipe(map(res => (this.data = res)));
  }
  // getbyname(code:string){
  //   return this.http.get(this.url1 + '/' + code)
  //   .pipe( map(res => this.data = res));
  // }
  getbyname(code: string) {
    return this.http
      .get(this.url1 + "/" + code);
  }
}
