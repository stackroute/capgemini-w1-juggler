import { Component, OnInit } from "@angular/core";
import { MovieDetailsService } from "../moviedetails.service";
import { Theatre } from "../theatre";
import { Movie } from "../movie";
import { MovieDisplay } from "../MovieDisplay";

@Component({
  selector: "app-theatre-display",
  templateUrl: "./theatre-display.component.html",
  styleUrls: ["./theatre-display.component.scss"]
})
export class TheatreDisplayComponent implements OnInit {
  movieObject2: MovieDisplay;
  theatreList: Theatre;
  today: number;
  tomorrow = [];
  count: number;
  dateValue: number;
  validDate: string;
  shows = [];
  noOfShows: number;
  prices = [];
  priceSeats = [];
  seats = [];
  i: number;
  weekday: boolean;
  weekend: boolean;
  constructor(private movieDetailsService: MovieDetailsService) {}

  ngOnInit() {
    this.movieObject2 = this.movieDetailsService.receive();
    // this.validDate = this.movieObject2.movieReleasedate;
    // var date = new Date("this.validDate");
    // console.log(date.toDateString());
    this.theatreList = this.movieObject2["theatres"];
    console.log(this.theatreList);
    this.shows = this.theatreList["showTimings"];
    //this.today = this.validDate.now();
    //Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
    this.today = Date.now();
    // console.log(this.today);
    this.count = 0;
    this.dateValue = this.today;

    // this.tomorrow[j]=this.today[i]+(24*60*60*1000);
    while (this.count < 7) {
      this.tomorrow[this.count] = this.dateValue;

      this.dateValue = this.dateValue + 24 * 60 * 60 * 1000;
      this.count++;
    }
  }
  determineDay(day) {
    if (day === "Sat" || day === "Sun") 
    this.weekend = true;
    else
     this.weekend = false;
    return this.weekend;


  }
}
