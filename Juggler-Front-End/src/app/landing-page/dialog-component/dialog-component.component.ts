import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dialog-component',
  templateUrl: './dialog-component.component.html',
  styleUrls: ['./dialog-component.component.scss']
})
export class DialogComponentComponent implements OnInit {

  city = ['Bangalore','Hyderabad','Mumbai','Chennai'];
  constructor(
        public dialogRef: MatDialogRef<DialogComponentComponent>, private router: Router) {}

  onClick(): void {
    this.dialogRef.close();
  }
  ngOnInit() {
  }
  searchMovies(city: string) {
    console.log(city);
    this.router.navigate(['home',city]);
    this.dialogRef.close();
  }
}
