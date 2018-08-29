//package com.stackroute.juggler.moviesearch.servicetest;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.stackroute.juggler.kafka.domain.City;
//import com.stackroute.juggler.kafka.domain.Movie;
//import com.stackroute.juggler.moviesearch.repository.CityRepository;
//import com.stackroute.juggler.moviesearch.repository.MovieRepository;
//import com.stackroute.juggler.moviesearch.services.MovieSearchServiceImpl;
//
//
//@RunWith(SpringRunner.class)
//public class SearchServiceTests {
//
//	
//	@MockBean
//	private transient CityRepository cityRepository;
//	
//	@MockBean
//	private transient MovieRepository movieRepository;
//	
//	@InjectMocks
//	private transient MovieSearchServiceImpl searchServiceImpl;
//	
//	
//	private transient Movie movie1, movie2,movie3;
//	@SuppressWarnings("unused")
//	private transient City city1, city2;
//	@Before
//	public void setUp() throws Exception {
//		MockitoAnnotations.initMocks(this);
//		
//		movie1 = new Movie(1,"bahubali", null, null, null, null, null, null, null, null, null, null, null);
//		movie2 = new Movie(2, "geetha", null, null, null, null, null, null, null, null, null, null, null);
//		movie3 = new Movie(3, "geetha", null, null, null, null, null, null, null, null, null, null, null);
//		
//		List<Movie> movieList1 = new ArrayList<Movie>();
//		movieList1.add(movie1);
//		
//		List<Movie> movieList2 = new ArrayList<Movie>();
//		movieList2.add(movie2); movieList2.add(movie3);
//		
//		city1 = new City("1", "hyderabad", movieList2);
//		city2 = new City("2", "bangalore", movieList2);
//	}
//	@Test
//public void testgetcityByCityName() throws Exception {
//	
//
//	when(cityRepository.save(city1)).thenReturn(city1);
//	
//	assertEquals(movie1, searchServiceImpl.getByCity("hyderabad"));
//	
//	when(searchServiceImpl.getByCity("hyderabad")).thenReturn(city1);
//	Iterable<Movie> allMovies = searchServiceImpl.getByTitle("hyderabad");
//	
//	assertEquals(city1, allMovies);
//}
//	
//}
