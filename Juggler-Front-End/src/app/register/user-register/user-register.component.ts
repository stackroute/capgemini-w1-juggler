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

  // hide = true;
  user = new User();

  constructor(private userService: UserService, private _formBuilder: FormBuilder) { }
  // emailFormControl = new FormControl('', [
  //   Validators.required,
  //   Validators.email,
  // ]);
  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
        userName: ['', Validators.required],
        email: ['', Validators.email],
        password: ['', Validators.required],
        mobileNo: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
        address: ['', Validators.required]
    });
  }
  get f() {
    return this.firstFormGroup.controls;
  }
  get f1() {
    return this.secondFormGroup.controls;
  }

  addUser() {
    this.user.user_name = this.f.userName.value;
    this.user.email_id = this.f.email.value;
    this.user.password = this.f.password.value;
    this.user.mobileNo = this.f.mobileNo.value;
    this.user.location = this.f1.address.value;
    console.log(this.user.user_name);
    console.log(this.user);
    this.userService
      .saveUser(this.user)
      .subscribe(res => console.log('Saved User'));
  }
}
