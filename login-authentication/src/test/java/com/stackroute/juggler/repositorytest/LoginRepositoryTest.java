//package com.stackroute.juggler.repositorytest;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.stackroute.juggler.kafka.domain.User;
//import com.stackroute.juggler.repository.UserDao;
//// class to test MovieRepository
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class LoginRepositoryTest {
//
//	@Autowired
//	private transient UserDao repo;
//	public void setRepo(final UserDao repo) {
//		this.repo = repo;
//	}
//	@Test
//	public void testSaveUser() throws Exception {
//	Date date =new Date();
//		repo.save(new User(1L,"vishnu","123",null,"user",date));
//		final User user = repo.findByEmail("vishnu");
//		assertThat(user.getPassword()).isEqualTo("123");
//	}
//	
//}
