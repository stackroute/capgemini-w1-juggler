//package com.stackroute.juggler.movieschedule;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import com.stackroute.juggler.kafka.domain.MovieDetails;
//import com.stackroute.juggler.kafka.domain.MovieSchedule;
//import com.stackroute.juggler.kafka.domain.TicketPrices;
//import com.stackroute.juggler.movieschedule.repository.MovieScheduleRepository;
//import com.stackroute.juggler.movieschedule.service.MovieServiceScheduleImpl;
//
//public class MovieScheduleServiceImplTest {
//
//	@Mock
//	private MovieScheduleRepository movieRepo;
//
////	@Mock
////	private MovieScheduleService movieService;
//
//	@InjectMocks
//	private MovieServiceScheduleImpl movieServiceImpl;
//
//	private MovieSchedule movie;
//
//	Optional<MovieSchedule> options;
//
//	@Before
//	public void setupMock() {
//		MockitoAnnotations.initMocks(this);
//		String theatreId = new String("1");
//		String theatreName = new String("PVR");
//		String theatreLocation = new String("Koramangala");
//		String theatreCity = new String("Bangalore");
//		String theatreLicenseNo = new String("L100A");
//		String numberOfSeats = new String("100");
//		Map<String, Integer> seats = new HashMap<String, Integer>();
//		seats.put("Platinum", 40);
//		seats.put("Gold", 60);
//		String[] screenedmovies = new String[] { "abcd", "Avengers" };
//		String[] runningmovies = new String[] { "Batman" };
//		MovieDetails movieDetails = new MovieDetails("1", "Batman", "url", "bcd", "abcd", "xyz", "action", "aeiou",
//				"2D", "English", "02:00:00", "2018-08-29");
//		int showNumbers = 4;
//		String[] showTimings = new String[] { "10:00", "13:00", "18:00", "22:00" };
//		TicketPrices ticketPrices = new TicketPrices(150, 100);
//
//		movie = new MovieSchedule(theatreId, theatreName, theatreLocation, theatreCity, theatreLicenseNo, numberOfSeats,
//				seats, screenedmovies, runningmovies, movieDetails, showNumbers, showTimings, ticketPrices);
//		options = Optional.of(movie);
//
//	}
//
//	@Test
//	public void testMockCreation() {
//		assertNotNull(movie);
//		assertNotNull("jpaRepository creation fails: use @injectMocks on movieServicempl", movieRepo);
//	}
//
//	@Test
//	public void testSaveMovieSuccess() throws Exception {
//		when(movieRepo.save(movie)).thenReturn(movie);
//		MovieSchedule flag = movieServiceImpl.addMovieSchedule(movie);
//		assertEquals("saving movie failed , the call to movieDAOImpl is returning false ,check this method", movie,
//				flag);
//		verify(movieRepo, times(1)).save(movie);
//
//	}
//
//}
