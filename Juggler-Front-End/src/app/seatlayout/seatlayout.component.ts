import { LayoutToBillingService } from "./../layout-to-billing.service";
import { Component, OnInit, DoCheck } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { BookingDetailsService } from "../booking-details.service";
import { FullBookingDetails } from "../FullBookingDetails";
import { TicketEngineService } from "../ticket-engine.service";
import { Observable } from "rxjs/Rx";
import * as Stomp from "stompjs";
import * as SockJS from "sockjs-client";
import { Layout } from "../layout";
import { Blocking } from "../blocking";
import { count } from "rxjs/operators";
declare var $: any;

@Component({
  selector: "app-seatlayout",
  templateUrl: "./seatlayout.component.html",
  styleUrls: ["./seatlayout.component.scss"]
})
export class SeatlayoutComponent implements OnInit {
  selectedvalue;
  seatingValue = [];
  totalRow = [];
  totalCol = [];
  jsonRow: any[];
  blockedSeatsArray;
  seatNum: any[];
  platinumrows = [];
  goldrows = [];
  silverrows = [];
  passage = [];
  buttonColor: string;
  x = [];
  y = [];
  data: any;
  rowPassage;
  division = [];
  blockedSeats = [];
  bookedSeats = [];
  seating = [];
  seatname = [];
  bookingDetail: FullBookingDetails;
  layoutobj: Layout;
  json: any;
  local = [];
  userblockedseats = [];
  blocked: any;
 
  userbookedseats = [];

  private serverUrl = "http://172.23.239.49:9079/websocket";
  private stompClient;

  constructor(
    private http: HttpClient,
    private detailService: BookingDetailsService,
    private ticketengineService: TicketEngineService,
    private layouttobilling: LayoutToBillingService
  ) {
    this.webSocketConnect();
  }

  ngOnInit() {
    this.bookingDetail = this.detailService.receive();
    this.layouttobilling.sendToBilling(this.bookingDetail);
    console.log(this.bookingDetail.showId + " anmishaaa");
    this.blockedSeatsArray = [];
    console.log("inside ngonit");
    this.seatname = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
    this.ticketengineService
      .getseatDetails(this.bookingDetail.showId)
      .subscribe(data => {
        this.json = data;
        this.totalRow.length = this.json.totalRow;
        this.totalCol.length = this.json.totalCol;
        this.totalRow = this.json.rowValues;
        this.totalCol = this.json.colValues;
        this.blockedSeats = this.json.blockedSeats;
        this.bookedSeats = this.json.bookedSeats;
        console.log(this.totalRow);
        console.log(this.totalCol);
        console.log(this.blockedSeats);
        console.log(this.bookedSeats);
        this.createseating();
      });
  }
  // ngDoCheck():void {
  //   window.location.reload;
  //   console.log("inside changes");
  // }

  webSocketConnect() {
    Observable.interval(1000 * 10).subscribe(() => {
      // console.log('1111---hi');
      this.ticketengineService.getData(
        this.bookingDetail.showId,
        this.blockedSeatsArray
      );
      // if (this.stompClient.onclose) {
      //   this.ticketengineService.getData().subscribe();}
    });
    setTimeout(()=>{},10000);

    console.log("inside method webSocketConnect ");
    var socket = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(socket);
    let that = this;
    this.stompClient.connect(
      {},
      function(frame) {
        console.log("Connected: " + frame);
        that.stompClient.subscribe("/movie", data => {
          if (data.body) {
            console.log("receiving from backend ", data.body);
            this.blocked = data.body;
            console.log("hi", this.blocked);
          }
        });
      }
    );
  }

  sendMessage() {
    let data = JSON.stringify({
      showId: this.bookingDetail.showId,
      blockedSeats: this.blockedSeatsArray
    });
    this.stompClient.send("/app/message", {}, data);
  }
  // add the seat number to array when clicked
  onclick(x, y) {
    let selected = x * 10 + y + 1;
    let count = 0;
    var flag = this.blockedSeatsArray.every(find);
    if (flag) {
      this.blockedSeatsArray.push(selected);
     count++;
    } else {
      let index = this.blockedSeatsArray.indexOf(selected);
      this.blockedSeatsArray.splice(index, 1);
    }
    console.log(this.blockedSeatsArray);

    function find(element) {
      return selected != element;
    }
    this.bookingDetail.selectedSeats = this.blockedSeatsArray;
    this.bookingDetail.totalNoOfTickets = count;
    this.bookingDetail.totalAmount = count * 250;
    this.bookingDetail.selectedSeatType="platinum";
    console.log(this.bookingDetail.totalAmount + "madhusri");
    this.layouttobilling.sendToBilling(this.bookingDetail);
  }

  createseating() {
    console.log(this.totalRow.length);
    for (let i = 0; i < this.totalRow.length; i++) {
      for (let j = 0; j < this.totalCol.length; j++) {
        const seatingStyle = '<div class="seat available"></div>';
        this.seatingValue.push(seatingStyle);
        // console.log(this.seatingValue);
        if (j === this.totalCol.length - 1) {
          console.log("Inside the break line loop");
        }
      }
    }

    $(function() {
      $(".seat").on("click", function() {
        if ($(this).hasClass("selected")) {
          $(this).removeClass("selected");
          // console.log("css removed");
          // console.log("Seat Id: " + this.id + " is removed");
        } else {
          $(this).addClass("selected");
          console.log("css added");
        }
      });
    });
  }
  // CHECKING WHETHER SEAT IS BLOCKED
  seatStatus(row, col) {
    var flag = false;
    // console.log(this.blockedSeats);
    var seatId = row * 10 + col + 1;
    for (var i = 0; i < this.blockedSeats.length; i++) {
      if (this.blockedSeats[i] == seatId) {
        flag = true;
        return flag;
      }
    }
  }
  // CHECKING WHETHER
  seatBook(row, col) {
    var flag = false;
    var seatId = row * 10 + col + 1;
    for (var i = 0; i < this.bookedSeats.length; i++) {
      if (this.bookedSeats[i] == seatId) {
        console.log(this.bookedSeats[i]);
        flag = true;
        return flag;
      }
    }
  }
}
