//package com.stackroute.juggler.userprofile;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
//import com.stackroute.juggler.kafka.domain.InputUser;
//import com.stackroute.juggler.kafka.domain.UserProfile;
//import com.stackroute.juggler.userprofile.controller.UserController;
//import com.stackroute.juggler.userprofile.service.UserService;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
//public class UserProfileControllerTest {
//
//	private MockMvc movieMockMvc;
//
//	@MockBean
//	private UserService userservice;
//
//	@InjectMocks
//	private UserController userController;
//
//	private InputUser user;
//	static List<InputUser> users;
//	private UserProfile profile;
//
//	@Before
//	public void setUp() throws Exception {
//
//		MockitoAnnotations.initMocks(this);
//
//		user = new InputUser("1", "amar", "amar@email.com", 1234, "male", "06/03/1997",null , null, null, "hyderabad", null, "sivaji");
//		profile = new UserProfile("1", null, null, null, "banglore", null, null);
//		movieMockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//
//	}
//
//	@Test
//	public void testSaveNewProfile() throws Exception {
//		when(userservice.saveUser(user)).thenReturn(user);
//		movieMockMvc.perform(post("/api/v1/userProfile/regestration").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//				.andExpect(status().isCreated()).andDo(print());
//		verify(userservice, times(1)).saveUser(Mockito.any(InputUser.class));
//		verifyNoMoreInteractions(userservice);
//	}
//	
//	@Test
//	public void testViewUser() throws Exception {
//		when(userservice.viewUser(user.getUserId())).thenReturn(user);
//		movieMockMvc.perform(get("/api/v1/userProfile/user/{userid}",1).contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//				.andExpect(status().isFound()).andDo(print());
//		verify(userservice, times(1)).viewUser("1");
//		verifyNoMoreInteractions(userservice);
//	}
//	
//
//
//	public static String asJsonString(final Object obj) {
//		try {
//			return new ObjectMapper().writeValueAsString(obj);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//}
