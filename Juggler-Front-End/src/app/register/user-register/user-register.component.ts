import { Component, OnInit } from '@angular/core';
import { UserService } from '../../user.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { User } from '../../user';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.scss']
})
export class UserRegisterComponent implements OnInit {
  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;

  hide = true;
  user = new User();
  // matcher = new MyErrorStateMatcher();
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
