import { Injectable } from "@angular/core";
import { Http, Headers } from "@angular/http";
@Injectable({
  providedIn: "root"
})
export class PaymentService {
  message: string;
  constructor(private http: Http) {}
  chargeCard(token: string, amount: number) {
    const headers = new Headers({ token: token, amount: amount });
    this.http
      .post(
        "http://10.20.1.15:9081/api/v1/payment/charge",
        {},
        { headers: headers }
      )
      .subscribe(resp => {
        console.log(resp);
        if (resp != null) {
          this.http
            .post("http://10.20.1.15:9081/api/v1/payment/ticket", {})
            .subscribe(response => {
              console.log(response);
            });
        } 
      });
  }

  refundCard() {
    this.http
      .post("http://10.20.1.15:9081/api/v1/payment/refund", {})
      .subscribe(res => {
        console.log(res);
      });
  }
}
