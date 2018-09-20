import { Component, OnInit } from "@angular/core";
import { Http } from "@angular/http";
import { HttpErrorResponse, JsonpClientBackend } from "@angular/common/http";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { BookingDetailsService } from "../booking-details.service";
import { FullBookingDetails } from "../FullBookingDetails";
import { TicketEngineService } from "../ticket-engine.service";
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
declare var $: any;


@Component({
  selector: "app-seatlayout",
  templateUrl: "./seatlayout.component.html",
  styleUrls: ["./seatlayout.component.scss"]
})
export class SeatlayoutComponent implements OnInit {
  public selectedvalue;
  public seatingValue = [];
  public totalRow = [];
  public totalCol = [];
  public jsonRow: any[];
  public id: any[];
  public seatNum: any[];
  public platinumrows = [];
  public goldrows = [];
  public silverrows = [];
  public passage = [];
  public buttonColor: string;
  public x = [];
  public y = [];
  data: any;
  rowPassage;
  division = [];
  blockedseats: any[];
  seating = [];
  seatname = [];
  bookingDetail: FullBookingDetails;

  private serverUrl = "http://172.23.239.47:9079/websocket";
  private stompClient;

  constructor(
    private http: HttpClient,
    private detailService: BookingDetailsService,
    private ticketengineService: TicketEngineService
  ) {
    this.webSocketConnect();
  }

  webSocketConnect() {
    var socket = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(socket);
    let that = this;
    that.stompClient.connect(
      {},
      function(frame) {
        console.log("Connected: " + frame);
        that.stompClient.subscribe("/movie", seats => {
          this.blockedseats = seats;
          // if(message.body) {
          //   $(".chat").append("<div class='message'>"+message.body+"</div>")
          console.log(1111);
          console.log(this.blockedseats+1111);
          // }
        });
      }
    );
  }

  ngOnInit() {
   
    this.bookingDetail = this.detailService.receive();
    console.log(this.bookingDetail);
    this.id = [];
    console.log("hi");
    this.seatname = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
    this.http.get("assets/layout.json").subscribe(result => {
      this.jsonRow = result as string[];
      this.division = this.jsonRow[0].division;
      this.totalRow.length = this.jsonRow[0].totalRow;
      this.totalCol.length = this.jsonRow[1].totalCol;
      this.totalRow = this.jsonRow[0].Values;
      this.totalCol = this.jsonRow[1].Values;
      this.passage = this.jsonRow[2].passageCol;
      this.rowPassage = this.jsonRow[1].passageRow;
      this.createseating();
    });
    // this.ticketengineService.getseatDetails().subscribe(res => {
    //   this.blockedseats = res;

    //   console.log(this.blockedseats);
    // });
  }

  bookticket() {}
  selectChangeHandler(event: any) {
    this.selectedvalue = event.target.value;
    console.log(this.selectedvalue);
  }
  onclick(x, y) {
    this.id.push(x * 10 + y + 1);
    this.id.sort();
    console.log(this.id);
    this.seatselect();
  }
  seatselect() {}
  seatstatus(row, col) {
    // const seatnumber = ((row * 10) + col + 1);
    // for (let i = 0; i < this.id.length; i++ ) {
    //   if (seatnumber === this.id[i]) {
    // console.log('blocked');
    // return false;
    //   }
    return true;
  }

  createseating() {
    for (let i = 0; i < this.totalRow.length; i++) {
      for (let j = 0; j < this.totalCol.length; j++) {
        const seatingStyle = '<div class="seat available"></div>';
        this.seatingValue.push(seatingStyle);
        // console.log(this.seatingValue);
        if (j === this.totalCol.length - 1) {
          //  console.log('Inside the break line loop');
        }
      }
    }

    $(function() {
      $(".seat").on("click", function() {
        if ($(this).hasClass("selected")) {
          $(this).removeClass("selected");

          console.log("removed");
        } else {
          $(this).addClass("selected");
          console.log("added");
        }
      });
    });
  }
}
