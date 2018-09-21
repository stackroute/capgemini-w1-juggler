import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Subject }    from 'rxjs/Subject';
@Injectable({
  providedIn: 'root'
})
export class SharingDataService {
cityName:string;
MovieName:string;
  constructor() { }
  receiveCityName(name:string){
this.cityName=name;
  }
  sendCityName(){ 
return this.cityName;
  }
  // receiveMovieName(name:string){
  //   this.MovieName=name;
  //     }
  //     sendMovieName(){ 
  //   return this.MovieName;
  //     }
  private messageSource = new BehaviorSubject("default message");
  currentMessage = this.messageSource.asObservable();



  changeMessage(message: string) {
    this.messageSource.next(message);
    console.log(message);
  }





}
