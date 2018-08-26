package com.stackroute.juggler.theatreregistration.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.juggler.theatreregistration.domain.Registration;
import com.stackroute.juggler.theatreregistration.repository.RegistrationRepository;
import com.stackroute.juggler.theatreregistration.services.RegistrationService;
import com.stackroute.juggler.theatreregistration.services.RegistrationServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
	
	@Mock
	private RegistrationRepository theatreRepo;
	
	@Mock
	private RegistrationService theatreService;
	
	private MockMvc theatreMockMvc;

	@InjectMocks
	private RegistrationServiceImpl theatreServiceImpl;

	  private Registration theatre;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
//		theatreServiceImpl=new RegistrationServiceImpl(theatreRepo);
	
//		Map<String, Integer> map = new HashMap<>();
//		map.put("platinum", 50);
//		map.put("gold", 25);
//		map.put("silver", 25);
//
//		String[] sm = new String[] { "temper","billa" };
//		String[] rm = new String[] { "geetha govindham","Antman" };
//
//		theatre = new Registration("802", "koramangala-5-67", "chennai", "xyz", "7", "100", map, sm, rm);
	}
	
//	@Test
//	public void testMockCreation() {
//      
//		Map<String, Integer> map = new HashMap<>();
//		map.put("platinum", 50);
//		map.put("gold", 25);
//		map.put("silver", 25);
//
//		String[] sm = new String[] { "temper","billa" };
//		String[] rm = new String[] { "geetha govindham","Antman" };
//
//		theatre = new Registration("802", "koramangala-5-67", "chennai", "xyz", "7", "100", map, sm, rm);
//		
//		assertNotNull(theatre);
//		assertNotNull("jpaRepository creation fails: use @injectMocks on movieServicempl", theatreRepo);
//	}
//	
	@Test
	public void testSaveTheatreSuccess() throws Exception {
		Map<String, Integer> map = new HashMap<>();
		map.put("platinum", 50);
		map.put("gold", 25);
		map.put("silver", 25);
		String[] sm = new String[] { "temper","billa" };
		String[] rm = new String[] { "geetha govindham","Antman" };
		theatre = new Registration("802", "koramangala-5-67", "chennai", "xyz", "7", "100", map, sm, rm);
		when(theatreRepo.save(theatre)).thenReturn(theatre);
		Registration returnedtheatre =theatreService.saveTheatre(theatre);
		assertEquals(theatre,returnedtheatre);
		verify(theatreRepo, times(1)).save(theatre);
		
//	verify(theatreRepo, times(1)).findById(theatre.getId());
	}
	
}
