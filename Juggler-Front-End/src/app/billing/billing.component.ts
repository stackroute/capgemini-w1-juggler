import { LayoutToBillingService } from './../layout-to-billing.service';

import { PromocodeService } from "./../promocode.service";
import { Component, OnInit } from "@angular/core";
import { FullBookingDetails } from "../FullBookingDetails";



export interface result {
  id:number;
  code:string;
  image:string;
  description:string;
  amount:string;
}
@Component({
  selector: "app-billing",
  templateUrl: "./billing.component.html",
  styleUrls: ["./billing.component.scss"]
})
export class BillingComponent implements OnInit {
//  result:any;
  promos: string;
  value: number;
  flag: boolean;
  show: boolean = true;
  result1 = null;
  bool;
  bookingDetails: FullBookingDetails;
  
 result=[
  {
    id:1,
    code:"FLAT100",
    image:"http://4.bp.blogspot.com/-A3aLFetzU34/VhVklMdjOcI/AAAAAAAAASs/xPSWi_SyPuk/s1600/Untitled1865-358x256.png", 
    description:"It is applicable from 500Rs on Ticket",
  amount: 100
  },
  {
    id:1,
    code:"FLAT200",
    image:"http://4.bp.blogspot.com/-A3aLFetzU34/VhVklMdjOcI/AAAAAAAAASs/xPSWi_SyPuk/s1600/Untitled1865-358x256.png", 
    description:"It is applicable from 500Rs on Ticket",
  amount: 200
  }]
  constructor(private promoService: PromocodeService, private payment: PromocodeService,private layouttobilling: LayoutToBillingService) {}
  ngOnInit() {

    console.log(this.layouttobilling.getAtBilling()+ "anmisha");
    this.result1=null;
    // this.promoService.getpromos().subscribe(data => {
    //   this.result = data;
    //   this.bool = false;
    //   // console.log(this.bool);
    // });
    //  console.log(this.result);
  }

  promo(code) {
    this.result1=null;
    this.promos = code;
    this.promoService.getbyname(code).subscribe(
      data => {
        this.result1 = data;
        console.log("data is ", data);
      },
      error => {
        console.log("error is ", error);
        this.bool = true;
      }
    );
    // console.log("data is ", this.result1);
  }

  formula(value1: number, value2: number) {
    switch (value2) {
      case 200:
        if (value1 >= 1000) {
          this.flag = true;
        } else {
          this.flag = false;
        }
        break;
      case 100:
        if (value1 >= 500) {
          this.flag = true;
        } else {
          this.flag = false;
        }
        break;
      case 50:
        if (value1 >= 300) {
          this.flag = true;
        } else {
          this.flag = false;
        }
        break;
      case 20:
        if (value1 >= 200) {
          this.flag = true;
        } else {
          this.flag = false;
        }
        break;
      case 10:
        if (value1 >= 100) {
          this.flag = true;
        } else {
          this.flag = false;
        }
        break;
      default:
        this.flag = false;
    }

    if (this.flag == true) {
      this.value = value1 - value2;
    }
    this.payment.amount = this.value;
    console.log(this.value);
    
    return this.flag;
  }
  // openVerticallyCentered(content) {
  //   this.modalService.open(content, { centered: true });
  // }

 
}
