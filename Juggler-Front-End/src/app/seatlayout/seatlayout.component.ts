import { LayoutToBillingService } from './../layout-to-billing.service';
import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { BookingDetailsService } from "../booking-details.service";
import { FullBookingDetails } from "../FullBookingDetails";
import { TicketEngineService } from "../ticket-engine.service";
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
  count = 0;
  userbookedseats = [];

  private serverUrl = "http://172.23.239.47:9079/websocket";
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
   
    this.bookingDetail=this.detailService.receive();
    console.log(this.bookingDetail);
    this.blockedSeatsArray = [];
    console.log("inside ngonit");
    this.seatname = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
    this.ticketengineService.getseatDetails().subscribe(data => {
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

  webSocketConnect() {
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
            // console.log(this.blocked.showId);
          }
        });
      }
    );
  }

  sendMessage() {
    let data = JSON.stringify({
      showId: "pvr2219:00bangalore",
      blockedSeats: this.blockedSeatsArray
    });
    this.stompClient.send("/app/message", {}, data);
  }
  // add the seat number to array when clicked
  onclick(x, y) {
    let selected = x * 10 + y + 1;
    var flag = this.blockedSeatsArray.every(find);
    if (flag) {
      this.blockedSeatsArray.push(selected);
     this.count++;
    } else {
      let index = this.blockedSeatsArray.indexOf(selected);
      this.blockedSeatsArray.splice(index, 1);
    }
    console.log(this.blockedSeatsArray);

    function find(element) {
      return selected != element;
    }
    this.bookingDetail.selectedSeats=this.blockedSeatsArray;
    this.bookingDetail.totalNoOfTickets=this.count;
   this.bookingDetail.totalAmount=(this.count*250);
   console.log(this.bookingDetail.totalAmount+ "madhusri");
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
