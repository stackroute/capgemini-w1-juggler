import { Component, OnInit } from "@angular/core";
import { RsvpService } from "../rsvp.service";
@Component({
  selector: "app-rsvp-events-list",
  templateUrl: "./rsvp-events-list.component.html",
  styleUrls: ["./rsvp-events-list.component.scss"]
})
export class RsvpEventsListComponent implements OnInit {
  search_result1;
  email: string;
  constructor(private rsvpService: RsvpService) {}

  ngOnInit() {}

  getEvents(){  
    this.email = localStorage.getItem("currentUserEmail");
    console.log(this.email);
     this.rsvpService.searchEvent(this.email).subscribe(data => {
      this.search_result1 = data;
      console.log( this.search_result1);
     });
    
  
}
}  
