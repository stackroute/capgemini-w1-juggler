import { Injectable } from '@angular/core';
import { FullBookingDetails } from './FullBookingDetails';

@Injectable({
  providedIn: 'root'
})
export class LayoutToBillingService {
  public billing:FullBookingDetails;
  constructor() { }

  send(bookedData:FullBookingDetails) {
    this.billing = bookedData;
  }
  receive() {
    console.log("receive" + this.billing.selectedSeats);
    return this.billing;
  }
}


