import { MovieDataService } from './../movie-data.service';
import { Movie } from './../movie';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-distribution-registerform',
  templateUrl: './distribution-registerform.component.html',
  styleUrls: ['./distribution-registerform.component.scss']
})
export class DistributionRegisterformComponent implements OnInit {

  constructor(private cardservice:MovieDataService) { }

  ngOnInit() {
  }
  private mov = new Movie();
  addMovie(input) {
   
   
    this.mov.movieName= input.moviename;
this.mov.movieReleaseDate=input.movieReleaseDate;
    // this.mov.releaseYear = movie.release_date;
    
    return this.cardservice.addMovie(this.mov).subscribe(data => (this.mov = data));
  }
}


