import { Component, OnInit } from '@angular/core';
import {
  FormControl,
  FormControlName,
  FormGroup,
  FormBuilder,
  Validators
} from "@angular/forms";
import { Router, ActivatedRoute, ParamMap } from "@angular/router";
import { MatDialog } from "@angular/material";
import { Event } from "../event"; 
import{RsvpService} from "../rsvp.service";
@Component({
  selector: 'app-rsvp-event',
  templateUrl: './rsvp-event.component.html',
  styleUrls: ['./rsvp-event.component.scss']
})

export class RSVPEventComponent implements OnInit {
  showFiller = false;
isLinear = true;
rsvpForm1: FormGroup;
rsvpForm2: FormGroup;
rsvpForm3: FormGroup;
myControl = new FormControl();
Event=new Event();

  constructor(
    private rsvpService:RsvpService,
    private _formBuilder: FormBuilder,
   private router: Router,
    public dialog: MatDialog,
    private route: ActivatedRoute,) {} 

  ngOnInit() {
    this.rsvpForm1 = this._formBuilder.group({
eventName: [null, Validators.required],
creatorName:[null, Validators.required],
eventType:[null, Validators.required],
eventGuest:[null, Validators.required] })

this.rsvpForm2 = this._formBuilder.group({
eventDate:[null, Validators.required],
eventTime:[null, Validators.required],
eventDays:[null, Validators.required],
eventDuration:[null, Validators.required] })

this.rsvpForm3 = this._formBuilder.group({
Description:[null, Validators.required],
emailId:[null, Validators.required],
invitiesMail:[null, Validators.required],
phoneNo:[null, Validators.required]
   })
  }

   openDialog() {
this.Event.creatorOfEvent=this.f.creatorName.value;
this.Event.eventName=this.f.eventName.value;
this.Event.eventType=this.f.eventType.value;
this.Event.guestsofEvent=this.f.eventGuest.value;

this.Event.eventDate=this.f1.eventDate.value;
this.Event.eventTime=this.f1.eventTime.value;
this.Event.duration=this.f1.eventDuration.value;
this.Event.noOfDays=this.f1.eventDays.value;

this.Event.eventSynopsis=this.f2.Description.value;
this.Event.emailId=this.f2.emailId.value;
this.Event.invitiesMail=this.f2.invitiesMail.value;
this.Event.phoneNo=this.f2.phoneNo.value; 

this.rsvpService
      .addEvent(this.Event)
      .subscribe(res => console.log("Saved event"));
    this.router.navigate(["/home"]);
    console.log(this.Event);
   }

get f() {
    return this.rsvpForm1.controls;
  }
  get f1(){
    return this.rsvpForm2.controls;
  }
  get f2(){
return this.rsvpForm3.controls;
  }
}
  






