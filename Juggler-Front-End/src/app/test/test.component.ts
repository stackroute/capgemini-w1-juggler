import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent implements OnInit {
  search_result1:any
  constructor() { }

  ngOnInit() {
  }
  searchMovies(){
// this.search_result1=input;
console.log(this.search_result1);
  }
}
