import { Component } from "@angular/core";
import { MovieDetailsService } from "../moviedetails.service";
import { Theatre } from "../theatre";
import { Movie } from "../movie";
import { MovieDisplay } from "../MovieDisplay";
import { FullBookingDetails } from "../FullBookingDetails";
import { BookingDetailsService } from "../booking-details.service";

@Component({
  selector: "app-theatre-display",
  templateUrl: "./theatre-display.component.html",
  styleUrls: ["./theatre-display.component.scss"]
})
export class TheatreDisplayComponent {
  movieObject2: MovieDisplay;
  theatreList: Theatre;
  selectedDetails=new FullBookingDetails();
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

  constructor(private movieDetailsService: MovieDetailsService, private detailService:BookingDetailsService) {}

  ngOnInit() {
    this.movieObject2 = this.movieDetailsService.receive();
    console.log(this.movieObject2);
    

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
    if (day === "Sat" || day === "Sun") this.weekend = true;
    else this.weekend = false;
    return this.weekend;
  }

  saveShow(theatre,showtime: string) {
    console.log("avh,ng", showtime);
    this.selectedDetails.nameOfMovie = this.movieObject2.movieName;
    this.selectedDetails.moviePoster = this.movieObject2.moviePoster;
    this.selectedDetails.synopsis = this.movieObject2.synopsis;
    this.selectedDetails.movieReleasedate = this.movieObject2.movieReleasedate;
    this.selectedDetails.movieDuration = this.movieObject2.movieDuration;
    this.selectedDetails.format = this.movieObject2.format;
    this.selectedDetails.movieGenre = this.movieObject2.movieGenre;
    this.selectedDetails.languages = this.movieObject2.languages;
    this.selectedDetails.theaterName = theatre.theatreName;
    this.selectedDetails.theatreLocation = theatre.theatreLocation;
    this.selectedDetails.screeningTime = showtime;
    console.log(this.selectedDetails.nameOfMovie ,this.selectedDetails.theaterName, this.selectedDetails.screeningTime);
  console.log(this.selectedDetails);
  this.detailService.send(this.selectedDetails);
  }
}
