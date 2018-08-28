import { Component, OnInit } from '@angular/core';
import { UserService } from '../../user.service';
import {FormControl, FormGroupDirective, FormGroup, FormBuilder, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import { User } from '../../user';

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.scss']
})
export class UserRegisterComponent implements OnInit {
  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  // userid: number;
  // user_name: string;
  // email_id: string;
  // mobileNo: number;
  // password: string;
  // gender: string;
  // languages_known: string;
  // dateOfBirth: string;
  // location: string;
  // genre: string;
  // likes: string;
  // payment_methods: string;
  hide = true;
  user = new User();
  matcher = new MyErrorStateMatcher();
  constructor(private userService: UserService, private _formBuilder: FormBuilder) { }
  // emailFormControl = new FormControl('', [
  //   Validators.required,
  //   Validators.email,
  // ]);
  ngOnInit() {
  this.firstFormGroup = this._formBuilder.group({
    firstCtrl: ['', Validators.required],
    email: ['', Validators.required, Validators.email],
    password: ['', Validators.required],
    mobileNo: ['', Validators.required]
  });
  this.secondFormGroup = this._formBuilder.group({
    secondCtrl: ['', Validators.required]
  });
  }
  // addUser() {
  //   this.user.userid = this.userid;
  //   this.user.user_name = this.user_name;
  //   this.user.password = this.password;
  //   this.user.email_id = this.email_id;
  //   this.user.mobileNo = this.mobileNo;
  //   this.user.gender = this.gender;
  //   this.user.location = this.location;
  //   this.user.dateOfBirth = this.dateOfBirth;
  //   this.userService.saveUser(this.user).subscribe();
  // }
  addUser() {
    console.log(this.user.user_name);
    console.log(this.user);
    this.userService
      .saveUser(this.user)
      .subscribe(res => console.log('Saved User'));
  }
}
