//package com.stackroute.juggler.userprofile;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.juggler.userprofile.controller.UserController;
//import com.stackroute.juggler.userprofile.domain.User;
//import com.stackroute.juggler.userprofile.service.UserService;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
//public class UserProfileControllerTest {
//
//	private MockMvc userMockMvc;
//
//	@MockBean
//	private UserService userService;
//
//	@InjectMocks
//	private UserController userController;
//
//	private InputUser user;
//	static List<InputUser> users;
//
//	@Before
//	public void setUp() throws Exception {
//
//		MockitoAnnotations.initMocks(this);
//		userMockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//		// movies = new ArrayList<>();
//		// String userName = new String("Basha");
//		// String emailId = new String("basha123@gmail.com");
//		// String password = new String("abc123");
//		// String gender = new String("male");
//		// String[] LanguagesKnown = new String[] { "Telugu", "English" };
//		// String[] genre = new String[] { "Action", "Thriller" };
//		// String location = new String("Hyderabad");
//		// String[] paymentMethods = new String[] { "paytm", "netbanking" };
//		// String likes = new String("hello");
//		// movie = new
//		// Movie("1","RamLeela","something.com",actors,actress,directors,genres,"A
//		// heroine mad for hero fights against all the hurdles and losses
//		// him","14D",languages,localTime2,firstDay_2014);
//		// movies.add(movie);
//		// movie = new
//		// Movie("2","leelaKiMahima","something.com",actors,actress,directors,genres,"A
//		// heroine mad for hero fights against all the hurdles and losses
//		// him","14D",languages,localTime2,firstDay_2014);
//		// movies.add(movie);
//	}
//
//	@Test
//	public void testSaveNewUser() throws Exception {
//		String userName = new String("Basha");
//		String emailId = new String("basha123@gmail.com");
//		String password = new String("abc123");
//		String gender = new String("male");
//		String[] LanguagesKnown = new String[] { "Telugu", "English" };
//		String[] genre = new String[] { "Action", "Thriller" };
//		String location = new String("Hyderabad");
//		String[] paymentMethods = new String[] { "paytm", "netbanking" };
//		String likes = new String("hello");
//		user = new InputUser(1, userName, emailId, 1234567890, password, gender, "01/01/1990", LanguagesKnown, genre,
//				location, paymentMethods, likes);
//		when(userService.saveUser(user)).thenReturn(user);// says what to do when invoked by controller as there are
//															// no movie service methods as of time while testing
//		userMockMvc
//				.perform(post("/api/v1/userProfile/regestration").contentType(MediaType.APPLICATION_JSON)
//						.content(asJsonString(user)))// sending pojos
//				.andExpect(status().isOk()).andDo(print());
//		verify(userService, times(1)).saveUser(Mockito.any(InputUser.class));
//	}
//
//	public static String asJsonString(final Object obj) {
//		try {
//			return new ObjectMapper().writeValueAsString(obj);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//}