import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rsvp-accept',
  templateUrl: './rsvp-accept.component.html',
  styleUrls: ['./rsvp-accept.component.scss']
})
export class RsvpAcceptComponent implements OnInit {
 flagAccept:boolean=false;
 flagReject:boolean=false;
 flagAcceptLoop:boolean=false;
 flagRejectLoop:boolean=false;

 flagReaccept:boolean;
 countAccept:number=0;
 countReject:number=0;
 countReaccept:number=0;

  constructor() { }

  ngOnInit() {
  }
  accept(){
    this.flagAccept =true;
    this.countAccept++;
    console.log(this.countAccept);
    this.flagAcceptLoop=true;
  }
  reject(){
this.flagReject=true;
this.countReject++;
console.log(this.countReject);
this.flagRejectLoop=true;
  }
  // reAccept(){
  //   this.flagAccept =true;
  //   this.countAccept++;
  //   this.countReject--;
  //   console.log(this.countAccept,this.countReject);
  // }
  // reDecline(){
  //   this.flagReject=true;
  //   this.countReject++;
  //   this.countAccept--; 
  //   console.log(this.countAccept,this.countReject);
  // }
 

}
