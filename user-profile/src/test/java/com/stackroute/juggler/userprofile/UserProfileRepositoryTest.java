//package com.stackroute.juggler.userprofile;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import com.stackroute.juggler.userprofile.domain.User;
//import com.stackroute.juggler.userprofile.repository.UserRepository;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class UserProfileRepositoryTest {
//	
//	@Autowired
//	private transient UserRepository repo;
//	public void setRepo(final UserRepository repo) {
//		this.repo = repo;
//	}
//	@Test
//	public void testSaveMovie() throws Exception {
//		repo.save(new User(1,"String", null, 0, null, null, null, null, null, null, null, null));
//		final User user = repo.findByUserid(1);
//		assertThat(user.getUserid()).isEqualTo(1);
//	
//    }
//}
//
//
