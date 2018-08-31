package com.stackroute.juggler.recommendation.domain;

import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity
public class Movie{
	
		private int id;
		private String movieName;
		private String moviePoster;
		private String synopsis;
		private String movieReleasedate;
		private String movieDuration;
		private String language;
		private String movieGenre;
		private String format;
		private String hero;
		private String heroine;
		private String director;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getMovieName() {
			return movieName;
		}
		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}
		public String getMoviePoster() {
			return moviePoster;
		}
		public void setMoviePoster(String moviePoster) {
			this.moviePoster = moviePoster;
		}
		public String getSynopsis() {
			return synopsis;
		}
		public void setSynopsis(String synopsis) {
			this.synopsis = synopsis;
		}
		public String getMovieReleasedate() {
			return movieReleasedate;
		}
		public void setMovieReleasedate(String movieReleasedate) {
			this.movieReleasedate = movieReleasedate;
		}
		public String getMovieDuration() {
			return movieDuration;
		}
		public void setMovieDuration(String movieDuration) {
			this.movieDuration = movieDuration;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public String getMovieGenre() {
			return movieGenre;
		}
		public void setMovieGenre(String movieGenre) {
			this.movieGenre = movieGenre;
		}
		public String getFormat() {
			return format;
		}
		public void setFormat(String format) {
			this.format = format;
		}
		public String getHero() {
			return hero;
		}
		public void setHero(String hero) {
			this.hero = hero;
		}
		public String getHeroine() {
			return heroine;
		}
		public void setHeroine(String heroine) {
			this.heroine = heroine;
		}
		public String getDirector() {
			return director;
		}
		public void setDirector(String director) {
			this.director = director;
		}
//		public List<Theatre> getTheatres() {
//			return theatres;
//		}
//		public void setTheatres(List<Theatre> theatres) {
//			this.theatres = theatres;
//		}
}