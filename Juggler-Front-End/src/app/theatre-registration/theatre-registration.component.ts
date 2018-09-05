
import { Component, OnInit } from '@angular/core';
import {FormControl, FormControlName, FormGroup, FormBuilder, Validators} from '@angular/forms';
import { Theatre } from '../theatre';
import { TheatreService } from '../theatre.service';
import { Router } from '@angular/router';
import {map, startWith} from 'rxjs/operators';

// import {Observable} from 'rxjs';

@Component({
  selector: 'app-theatre-registration',
  templateUrl: './theatre-registration.component.html',
  styleUrls: ['./theatre-registration.component.scss']
})
export class TheatreRegistrationComponent implements OnInit {
  showFiller = false;
  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  myControl = new FormControl();
  options: string[] = ['Bengaluru', 'Chennai', 'Hyderabad', 'Jaipur', 'Kolkata', 'Lucknow', 'Mangalore', 'Mumbai', 'Pune'];
  // options: string[] = ['Bangalore', 'Chennai', 'Hyderabad', 'Pune'];
  // filteredOptions: Observable<string[]>;
  theatre = new Theatre();
  constructor(private theatreService: TheatreService, private _formBuilder: FormBuilder, private router: Router) { }
  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
        theatreName: ['', Validators.required],
        licenseNo: ['', Validators.required],
        City: ['', Validators.required],
        Capacity: ['', Validators.required],
    });
    this.secondFormGroup = this._formBuilder.group({
        address: ['', Validators.required],
         city: ['', Validators.required],
        state: ['', Validators.required],
        zip: ['', Validators.required],
        country: ['', Validators.required],
    });
    this.thirdFormGroup = this._formBuilder.group({
      type1: ['', Validators.required],
      type2: ['', Validators.required],
      type3: ['', Validators.required],
      n1: [Number, Validators.required],
      n2: [Number, Validators.required],
      n3: [Number, Validators.required],
    });
    // this.filteredOptions = this.myControl.valueChanges
    // .pipe(
    //   startWith(''),
    //   map(value => this._filter(value))
    // );
  }
  get f() {
    return this.firstFormGroup.controls;
  }
  get f1() {
    return this.secondFormGroup.controls;
  }
  get f2() {
    return this.thirdFormGroup.controls;
  }



  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();
return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }
onSubmit() {
  this.theatre.theatreCity = this.f.City.value;
  this.theatre.theatreLicenseNo = this.f.licenseNo.value;
  this.theatre.theatreLocation = this.f1.address.value + ',' +
                                  this.f1.city.value + ',' +
                                  this.f1.state.value + ',' +
                                  this.f1.zip.value + ',' +
                                  this.f1.country.value;
  this.theatre.theatreName =  this.f.theatreName.value;
  // tslint:disable-next-line:no-shadowed-variable
  const map = new Map<String , String>();
   map.set(this.f2.type1.value, this.f2.n1.value);
  map.set(this.f2.type2.value , this.f2.n2.value);
  map.set(this.f2.type3.value , this.f2.n3.value);
  this.theatre.seats = map;
  console.log(this.theatre.theatreName);
  console.log(this.theatre);

this.theatreService
      .saveTheatre(this.theatre)
      .subscribe(res => console.log('Saved theatre'));
      this.router.navigate(['/home']);
  console.log(this.theatre);
}

}


