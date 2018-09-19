import { Component, OnInit } from "@angular/core";
import { PaymentService } from "../paymentservice";
import { MatDialog } from "@angular/material";
import { PromocodeService } from "../promocode.service";

@Component({
  selector: "app-payment-page",
  templateUrl: "./payment-page.component.html",
  styleUrls: ["./payment-page.component.scss"]
})
export class PaymentPageComponent implements OnInit {
  cardNumber: string;
  expiryMonth: string;
  expiryYear: string;
  cvc: string;
  amount = this.amt.amount;
  token: string;
  msg: string;
  chargeId: string;

  // fileNameRef: MatDialogRef<PaymentDialogComponent>;
  constructor(
    private paymentService: PaymentService,
    private amt: PromocodeService,
    public dialog: MatDialog
  ) {}
  chargeCreditCard() {
    (<any>window).Stripe.card.createToken(
      {
        number: this.cardNumber,
        exp_month: this.expiryMonth,
        exp_year: this.expiryYear,
        cvc: this.cvc
      },
      (status: number, response: any) => {
        if (status === 200) {
          this.token = response.id;
          console.log(this.amount);
          this.paymentService.chargeCard(this.token, this.amount);
          this.msg = "Transaction Success";
          console.log(this.token);
          if (this.token == null) {
            this.msg =
              "Transaction failure! Plase Check Your Internet Connection";
          }
        } else {
          console.log(response.error.message);
          this.msg = "Transaction Failed Because " + response.error.message;
        }
      }
    );
  }

  refundCreditCard() {
    this.paymentService.refundCard();
  }

  ngOnInit() {}
}
