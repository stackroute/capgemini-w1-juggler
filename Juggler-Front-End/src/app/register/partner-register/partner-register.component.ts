import { Component, OnInit } from '@angular/core';
// import { FormBuilder, FormGroup, Validators } from '@angular/forms';
// import { AlertService } from '../user-login/../../alert.service';

@Component({
  selector: 'app-partner-register',
  templateUrl: './partner-register.component.html',
  styleUrls: ['./partner-register.component.scss']
})
export class PartnerRegisterComponent implements OnInit {
role: string;
//   registerForm: FormGroup;
//   loading = false;
//   submitted = false;
//   constructor(private formBuilder: FormBuilder, private alertService: AlertService) { }

  ngOnInit() {
//     this.registerForm = this.formBuilder.group({
//       email: ['', Validators.required],
//       password: ['', Validators.required]
//   });
  }
//   get f() {
//     return this.registerForm.controls;
//   }
//   onSubmit() {}
}
