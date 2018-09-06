import { Component, OnInit } from "@angular/core";
import { UserService } from "../../user.service";
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormControl,
  FormArray,
  ValidatorFn
} from "@angular/forms";
import { User } from "../../user";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { map, startWith } from "rxjs/operators";

export interface Language {
  name: string;
}

@Component({
  selector: "app-user-register",
  templateUrl: "./user-register.component.html",
  styleUrls: ["./user-register.component.scss"]
})
export class UserRegisterComponent implements OnInit {
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  // thirdFormGroup: FormGroup;
  fourthFormGroup: FormGroup;
  languageCtrl = new FormControl();
  genres = new FormControl();
  filteredLanguages: Observable<Language[]>;
  genderGroup: string[] = ["Male", "Female"];
  gender;

  // genres = [
  //   { id: 1, name: "Horror", img: "assets/images/Horror.jpeg" },
  //   { id: 2, name: "Thriller", img: "assets/images/Thriller.jpeg" },
  //   { id: 3, name: "Fiction", img: "assets/images/Fiction.jpeg" },
  //   { id: 4, name: "Animation", img: "assets/images/Animation.jpeg" }
  // ];

  genreList: string[] = [
    "Action",
    "Drama",
    "Bio-Graphy",
    "Romance",
    "Thriller",
    "Comedy"
  ];
  user = new User();
  languages: Language[] = [
    {
      name: "Bengali"
    },
    {
      name: "English"
    },
    {
      name: "Hindi"
    },
    {
      name: "Telugu"
    }
  ];

  constructor(
    private userService: UserService,
    private _formBuilder: FormBuilder,
    private router: Router
  ) {
    this.filteredLanguages = this.languageCtrl.valueChanges.pipe(
      startWith(""),
      map(
        language =>
          language ? this._filterLanguages(language) : this.languages.slice()
      )
    );
    // const controls = this.genres.map(c => new FormControl(false));
    // controls[0].setValue(true);

    // this.fourthFormGroup = this._formBuilder.group({
    //   genres: new FormArray(controls, minSelectedCheckboxes(1))
    // });
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
    // this.fourthFormGroup = this._formBuilder.group({
    //   i: ["", Validators.required]
    // });
  }

  get f() {
    return this.firstFormGroup.controls;
  }
  get f1() {
    return this.secondFormGroup.controls;
  }
  // get f2() {
  //   return this.thirdFormGroup.controls;
  // }
  private _filterLanguages(value: string): Language[] {
    const filterValue = value.toLowerCase();
    return this.languages.filter(
      language => language.name.toLowerCase().indexOf(filterValue) === 0
    );
  }

  addUser() {
    this.user.userName = this.f.userName.value;
    this.user.emailId = this.f.email.value;
    this.user.password = this.f.password.value;
    this.user.mobileNo = this.f.mobileNo.value;
    this.user.location = this.f1.address.value;
    this.user.LanguagesKnown = this.languageCtrl.value;
    this.user.genre = this.genres.value;
    // this.user.gender = this.gender.value;
    console.log(this.genres.value);
    console.log(this.user.userName);
    // console.log(this.user);
    // const selectedGenreIds = this.fourthFormGroup.value.genres
    //   .map((v, i) => (v ? this.genres[i].id : null))
    //   .filter(v => v !== null);
    // console.log(selectedGenreIds);
    this.userService
      .saveUser(this.user)
      .subscribe(res => console.log("Saved User"));
    this.router.navigate(["/login-user"]);
  }
}
// function minSelectedCheckboxes(min = 1) {
//   const validator: ValidatorFn = (formArray: FormArray) => {
//     const totalSelected = formArray.controls
//       .map(control => control.value)
//       .reduce((prev, next) => (next ? prev + next : prev), 0);

//     return totalSelected >= min ? null : { required: true };
//   };

//   return validator;
// }
