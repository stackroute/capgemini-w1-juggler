import { Component, OnInit } from "@angular/core";
import { UserService } from "../../user.service";
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormControl
} from "@angular/forms";
import { User } from "../../user";
import { Router } from "@angular/router";
export interface Language {
  name: string;
}

@Component({
  selector: "app-user-register",
  templateUrl: "./user-register.component.html",
  styleUrls: ["./user-register.component.scss"]
})
export class UserRegisterComponent implements OnInit {
  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  fourthFormGroup: FormGroup;
  languageCtrl = new FormControl;
  genderGroup: string[] = ["Male", "Female"];
  gender;

  genress = [
    { id: 1, name: "Thriller", img: "assets/images/Thriller.jpeg" },
    { id: 2, name: "Fiction", img: "assets/images/Fiction.jpeg" },
    { id: 3, name: "Horror", img: "assets/images/Horror.jpeg" },
    { id: 4, name: "Romance", img: "assets/images/Romance.jpeg"},
    { id: 5, name: "Drama", img: "assets/images/Drama.png"},
    { id: 6, name: "Crime", img: "assets/images/Crime.jpeg"},
    { id: 7, name: "Action", img: "assets/images/Action.jpeg"},
    { id: 8, name: "SuperHeroes", img: "assets/images/Super-Heroes.jpeg"}
  ];
  genreOutoutList: Array<string> = []; 

  user = new User();
  languages: string[] = [
    "Bengali",
    "English",
    "Hindi",
    "Kannada",
    "Malyalam",
    "Telugu",
    "Tamil"
  ];

  constructor(
    private userService: UserService,
    private _formBuilder: FormBuilder,
    private router: Router
  ) { }
  onGenreCardSelect(genre: any) {
    this.genreOutoutList.push(genre);
    console.log(this.genreOutoutList);
  }
  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      userName: ["", Validators.required],
      email: ["", Validators.email],
      password: ["", Validators.required],
      mobileNo: ["", Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      address: ["", Validators.required]
    });
  }

  get f() {
    return this.firstFormGroup.controls;
  }
  get f1() {
    return this.secondFormGroup.controls;
  }

  addUser() {
    this.user.userName = this.f.userName.value;
    this.user.emailId = this.f.email.value;
    this.user.password = this.f.password.value;
    this.user.mobileNo = this.f.mobileNo.value;
    this.user.location = this.f1.address.value;
    this.user.languagesKnown = this.languageCtrl.value;
    this.user.genre = this.genreOutoutList;
    // this.user.gender = this.gender.value;
    console.log(this.genreOutoutList);
    console.log(this.user.userName);
    console.log(this.user);
    this.userService
      .saveUser(this.user)
      .subscribe(res => console.log("Saved User"));
    this.router.navigate(["/login-user"]);
  }
}
