import { Injectable } from '@angular/core';

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
  receiveMovieName(name:string){
    this.MovieName=name;
      }
      sendMovieName(){ 
    return this.MovieName;
      }
}
