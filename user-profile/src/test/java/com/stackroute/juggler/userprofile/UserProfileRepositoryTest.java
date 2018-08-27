//package com.stackroute.juggler.userprofile;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
////import javax.persistence.EntityManagerFactory;
//
//import com.stackroute.juggler.userprofile.domain.User;
//import com.stackroute.juggler.userprofile.repository.UserRepository;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class UserProfileRepositoryTest {
//
//	@Autowired
//	private transient UserRepository userRepositary;
//
//	public void setRepo(final UserRepository userRepositary) {
//		this.userRepositary = userRepositary;
//	}
//
//	@Test
//	public void testSaveMovie() throws Exception {
//		String userName = new String("Basha");
//		String emailId = new String("basha123@gmail.com");
//		String password = new String("abc123");
//		String gender = new String("male");
//		String[] LanguagesKnown = new String[] { "Telugu", "English" };
//		String[] genre = new String[] { "Action", "Thriller" };
//		String location = new String("Hyderabad");
//		String[] paymentMethods = new String[] { "paytm", "netbanking" };
//		String likes = new String("hello");
//		userRepositary.save(new User(1, userName, emailId, 1234567890, password, gender, "01/01/1990", LanguagesKnown,
//				genre, location, paymentMethods, likes));
//		final User movie = userRepositary.findByUserId(1);
//		assertThat(movie.getUserName()).isEqualTo("Basha");
//	}
//
//}