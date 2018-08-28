import { Component, OnInit } from '@angular/core';
import { UserService } from '../../user.service';
import { User } from '../../user';


@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.scss']
})
export class UserRegisterComponent implements OnInit {
  // isLinear = false;
  // firstFormGroup: FormGroup;
  // secondFormGroup: FormGroup;
  userid: number;
  user_name: string;
  email_id: string;
  mobileNo: number;
  password: string;
  gender: string;
  languages_known: string;
  dateOfBirth: string;
  location: string;
  genre: string;
  likes: string;
  payment_methods: string;

  user = new User();
  constructor(private userService: UserService) { }

  ngOnInit() {

  }
  addUser() {
    this.user.userid = this.userid;
    this.user.user_name = this.user_name;
    this.user.password = this.password;
    this.user.email_id = this.email_id;
    this.user.mobileNo = this.mobileNo;
    this.user.gender = this.gender;
    this.user.location = this.location;
    this.user.dateOfBirth = this.dateOfBirth;
    this.userService.saveUser(this.user).subscribe();
  }
}
