//package com.stackroute.juggler.userprofile;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//
//import org.springframework.test.context.junit4.SpringRunner;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import com.stackroute.juggler.userprofile.domain.User;
//import com.stackroute.juggler.userprofile.repository.UserRepository;
//import com.stackroute.juggler.userprofile.service.UserService;
//import com.stackroute.juggler.userprofile.service.UserServiceImpl;
//
//
////@RunWith(MockitoJUnitRunner.class)
//public class UserProfileServiceImplTest {
//	
//	@Mock
//	private UserRepository userRepo;
//	
//	@Mock
//	private UserService userService;
//
//	@InjectMocks
//	private UserServiceImpl userServiceImpl;
//
//	private User user;
//	Optional<User> options;
//
//	@Before
//	public void setupMock() {
//		MockitoAnnotations.initMocks(this);
//		 userServiceImpl = new UserServiceImpl(userRepo, null);
//		user = new User(5,"name", null, 0, null, null, null, null, null, null, null, null);
//		options = Optional.of(user);
//
//	}
//
//	@Test
//	public void testMockCreation() {
//		assertNotNull(user);
//		assertNotNull("jpaRepository creation fails: use @injectMocks on movieServicempl", userRepo);
//	}
//
//	@Test
//	public void testSaveUserSuccess() throws Exception {
//		when(userRepo.save(user)).thenReturn(user);
//		assertNotNull(user);
//		User flag = new User();
//		 userService.saveUser(user);
//		//assertNotNull(flag);
//		assertEquals(user,flag);
//		verify(userRepo, times(1)).save(user);
//		//verify(userRepo, times(2)).findByUserid(user.getUserid());
//	}
//	
////	@Test
////	public void testViewUserSuccess() throws Exception {
////		when(userRepo.view(user)).thenReturn(user);
////		User flag = userServiceImpl.viewUser(user.getUserId());
////		User finduser = userServiceImpl.viewUser(flag.getUserId());
////		assertEquals(finduser,flag);
////		verify(userRepo, times(1)).save(user);
////		verify(userRepo, times(2)).findByUserId(user.getUserId());
////	}
//}
//
//
//
