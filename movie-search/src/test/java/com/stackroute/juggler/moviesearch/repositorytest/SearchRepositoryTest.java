//package com.stackroute.juggler.moviesearch.repositorytest;
//
//import static org.junit.Assert.assertThat;
//
//
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.stackroute.juggler.kafka.domain.Movie;
//import com.stackroute.juggler.moviesearch.repository.MovieRepository;
//
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//
//@RunWith(SpringRunner.class)
//
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class SearchRepositoryTest {
//
//	    private transient MovieRepository movieRepositary;
//	    @Autowired
//	    public void setMovieRepositary(final MovieRepository movieRepositary) {
//	        this.movieRepositary = movieRepositary;
//	    }
//
//    @Test
//    public void testSaveMovie() throws Exception {
//        String languages = "Telugu";
//        movieRepositary.save(new Movie(1, "bahubali", languages, languages, languages, languages, languages, languages, languages, languages, languages, languages, null));
//        final Movie movie = movieRepositary.getById(1);
//        assertThat(movie.getMovieName()).isEqualTo("bahubali");
//  }
//
//}