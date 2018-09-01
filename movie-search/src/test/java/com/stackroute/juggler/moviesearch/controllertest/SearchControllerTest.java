//package com.stackroute.juggler.moviesearch.controllertest;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.juggler.kafka.domain.City;
//import com.stackroute.juggler.kafka.domain.Movie;
//import com.stackroute.juggler.moviesearch.controller.MovieSearchController;
//import com.stackroute.juggler.moviesearch.services.MovieSearchService;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(MovieSearchController.class)
//public class SearchControllerTest {
//
//	private MockMvc movieMockMvc;
//
//	@MockBean
//	private MovieSearchService movieService;
//
//	@InjectMocks
//	private MovieSearchController movieController;
//
//	private Movie movie;
//	private City city;
//	static List<Movie> movies;
//
//	@Before
//	public void setUp() throws Exception {
//
//		MockitoAnnotations.initMocks(this);
//
//		
//		movieMockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
//		movies = new ArrayList<>();
//		movie= new Movie(1,"bahubali", null, null, null, null, null, null, null, null, null, null, null);
//		movies.add(movie);
//		movie = new Movie(2, "geetha", null, null, null, null, null, null, null, null, null, null, null);
//		movies.add(movie);
//		movie = new Movie(3, "geetha subraanyam", null, null, null, null, null, null, null, null, null, null, null);
//		movies.add(movie);
//	}
//
//	
//	
//	@Test
//	public void testgetbyMoviename() throws Exception {
//
//		when(movieService.getByTitle("bahubali")).thenReturn((List<Movie>) movies.get(1));
//		movieMockMvc.perform(get("/api/v1/movie/", "bahubali")).andExpect(status().isOk());
//		verify(movieService, times(1)).getByTitle("bahubali");
//		verifyNoMoreInteractions(movieService);
//	}
//}
