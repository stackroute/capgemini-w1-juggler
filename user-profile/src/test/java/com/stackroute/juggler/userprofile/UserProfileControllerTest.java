package com.stackroute.juggler.userprofile;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.juggler.userprofile.controller.UserController;
import com.stackroute.juggler.userprofile.domain.User;
import com.stackroute.juggler.userprofile.service.UserService;
import com.stackroute.juggler.userprofile.service.UserServiceImpl;

//@ContextConfiguration(classes=UserProfileApplication.class)
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserProfileControllerTest {

	private MockMvc userMockMvc;

	@MockBean
	private UserServiceImpl userService;

	@InjectMocks
	private UserController movieController;

	private User user;
	// static List<Movie> movies;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		user = new User(1, "hello", null, 0, null, null, null, null, null, null, null, null);
		userMockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
		// movies = new ArrayList<>();
		// movie = new Movie(1, "POC", "good Movie", "www.abc.com", "2015-03-23", 45.5,
		// 112, "Jhon123");
		// movies.add(movie);
		// movie = new Movie(2, "POC-2", "very good Movie", "www.cde.com", "2013-09-23",
		// 65.5, 110, "Jhon123");
		// movies.add(movie);
	}

	// @Test
	// public void testSaveNewUser() throws Exception {
	// when(userService.saveUser(user)).thenReturn(user);
	// userMockMvc.perform( ( post("/user/save")
	// .contentType(MediaType.APPLICATION_JSON))
	// .content(user.getUser_name()));
	// //.andExpect(status().isOk()).andDo(print()));
	// verify(userService, times(1)).saveUser(Mockito.any(User.class));
	// }
	@Test
		public void controllercheck()
		  throws Exception {
		     
		    User alex = new User();
		    alex.setUserid(1);
		    alex.setUser_name("alex");
		 
		    //List<Employee> allEmployees = Arrays.asList(alex);
		 
		    //given(userService.viewUser(alex.getUserid())).willReturn(alex);
		    when(userService.viewUser(1)).thenReturn(alex);
		 
		    userMockMvc.perform(get("/user/{userid}",1)
		      .contentType(MediaType.APPLICATION_JSON))
		      .andExpect(status().isOk())
		   // .andExpect(jsonPath("$.id", is(1)))
		    //.andExpect(jsonPath("$.user_name", is("alex")))
		    .andExpect(jsonPath("$.userid", is(1)));
		      //.andExpect(jsonPath("$[0].name", is(alex.getUser_name())));
		   // verify(userService, times(1)).viewUser(Mockito.any());
		    verify(userService, times(1)).viewUser(1);
		}

}
