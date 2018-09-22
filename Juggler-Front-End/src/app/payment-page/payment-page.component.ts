import { Component, OnInit } from "@angular/core";
import { PaymentService } from "../paymentservice";
import { MatDialog } from "@angular/material";
import { PromocodeService } from "../promocode.service";
import { NgxSpinnerService } from "ngx-spinner";

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
 // amount = this.amt.amount;
 amount: number = 50;
 token: string;
 msg: string;
 msg1: string;
 // bookingStatus: string;
 theatreName: string = "PVR";
 showId: string = "pvr701:00bangalore";
 movieName: string = "hi";
 bookedSeats: number[] = [1, 2, 3];
 showTiming: string = "01:00";

 // bookingDetails = new BookingDetails();

 // fileNameRef: MatDialogRef<PaymentDialogComponent>;
 constructor(
   private paymentService: PaymentService,
   private amt: PromocodeService,
   public dialog: MatDialog,
   private ngxSpinner: NgxSpinnerService
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
         this.amount = 50;
         console.log(this.amount);
         // this.bookingDetails.movieName = 'ABCD';
         // this.bookingDetails.showId = 'pvr701:00bangalore';
         // this.movieName = "ABCD";
         // this.showId = "pvr701:00bangalore";
         // this.theatreName = "pvr";
         // this.showTiming = "01:00";
         // this.bookedSeats = [1, 2, 3];
         // this.movieName, this.showId
         this.paymentService.chargeCard(
           this.token,
           this.amount,
           this.bookedSeats,
           this.showId,
           this.theatreName,
           this.movieName,
           this.showTiming
         );
         this.msg = "Transaction Success";
         console.log(this.token);
         if (this.token == null) {
           this.msg =
             "Transaction failure! Plase Check Your Internet Connection";
         }
       } else {
         console.log(response.error.message);
         this.msg1 = "Transaction Failed Because " + response.error.message;
       }
     }
   );
   this.ngxSpinner.show();
   setTimeout(() => {
     this.ngxSpinner.hide();
   }, 3000);
 }

 refundCreditCard() {
   this.paymentService.refundCard();
 }

 ngOnInit() {}
}