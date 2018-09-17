
import { PromocodeService } from "./../promocode.service";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-billing",
  templateUrl: "./billing.component.html",
  styleUrls: ["./billing.component.scss"]
})
export class BillingComponent implements OnInit {
  result;
  promos: string;
  value: number;
  flag: boolean;
  show: boolean = true;
  result1 = null;
  bool;

  constructor(private promoService: PromocodeService) {}

  ngOnInit() {
    this.result1=null;
    this.promoService.getpromos().subscribe(data => {
      this.result = data;
      this.bool = false;
      // console.log(this.bool);
    });
    // console.log(this.result1);
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
    return this.flag;
  }
  // openVerticallyCentered(content) {
  //   this.modalService.open(content, { centered: true });
  // }

 
}
