import { Injectable } from "@angular/core";
import { Http, Headers } from "@angular/http";
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: "root"
})
export class PaymentService {
  message: string;
  
  

  // amount: number;
  constructor(
    private http: Http, private https: HttpClient
  ) {}

  // msg = this.paymentPage.msg;
  chargeCard(token: string, amount: number) {
    console.log(this.message);
    // this.amount = 50;
    const headers = new Headers({ token: token, amount: amount });
    this.http
      .post("http://localhost:8031/api/v1/payment/charge", {}, { headers: headers })
      .subscribe(resp => {
        console.log(resp);
      });
      this.http.post("http://localhost:8031/api/v1/payment/ticket", {})
    .subscribe(response =>{
      console.log(response);
    });
  }

  refundCard() {
    this.http
      .post("http://localhost:8031/api/v1/payment/refund", {})
      .subscribe(res => {
        console.log(res);
      });
  }
}
