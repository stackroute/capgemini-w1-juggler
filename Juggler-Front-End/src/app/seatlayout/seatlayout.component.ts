import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { BookingDetailsService } from "../booking-details.service";
import { FullBookingDetails } from "../FullBookingDetails";
import { TicketEngineService } from "../ticket-engine.service";
import * as Stomp from "stompjs";
import * as SockJS from "sockjs-client";
import { Layout } from "../layout";
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

  private serverUrl = "http://172.23.239.47:9079/websocket";
  private stompClient;

  constructor(
    private http: HttpClient,
    private detailService: BookingDetailsService,
    private ticketengineService: TicketEngineService
  ) {
    this.webSocketConnect();
  }

  ngOnInit() {
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
      this.blockedSeatsArray = this.blockedSeats;
      this.bookedSeats = this.bookedSeats;
      console.log(this.totalRow);
      console.log(this.totalCol);
      console.log(this.blockedSeatsArray);
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
          }
        });
      }
    );
  }

  sendMessage(message) {
    let data = JSON.stringify({
      showId: "pvr701:00bangalore",
      blockedSeats: this.blockedSeatsArray
    });
    this.stompClient.send("/app/message", {}, data);
  }

  onclick(x, y) {
    let selected = x * 10 + y + 1;
    var flag = this.blockedSeatsArray.every(find);
    if (flag) {
      this.blockedSeatsArray.push(selected);
    } else {
      let index = this.blockedSeatsArray.indexOf(selected);
      this.blockedSeatsArray.splice(index, 1);
    }
    console.log(this.blockedSeatsArray);

    function find(element) {
      return selected != element;
    }
  }

  createseating() {
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
      $(this.blockedSeats).addClass("blocked");
    });
  }
  seatStatus(row, col) {
    var seatId = row * 10 + col + 1;
    // console.log("Seat ID : " + seatId);
    // console.log(this.blockedSeats.length);
    var i;

    for (i = 0; i < this.blockedSeats.length; i++) {
      if (this.blockedSeatsArray[i] === seatId) {
        console.log(this.blockedSeats[i]);
        return true;
      } else {
        return false;
      }
    }
  }
}
