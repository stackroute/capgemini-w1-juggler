import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharingDataService {
cityName:string;
  constructor() { }
  receiveCityName(name:string){
this.cityName=name;
  }
  sendCityName(){ 
return this.cityName;
  }
}
