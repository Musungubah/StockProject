package bmm.arsenal.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.junit.jupiter.api.*;

import bmm.arsenal.demo.model.User;
import bmm.arsenal.demo.repository.UserRepository;
import bmm.arsenal.demo.service.UserService;
import org.mockito.*;

public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	@InjectMocks
	private UserService mockUserService = new UserService(userRepository);
	@Mock
	private User user;

	@BeforeEach
	public void setup() {

		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testMockCreation() {
		assertNotNull(user);
		assertNotNull(mockUserService);
		assertNotNull(userRepository);
	}

	@Test
	public void testForAUser() {
//		User u = mockUserService.getAUserByUserName("user");
//		Assertions.assertEquals(u.getUsername(),"user","The username was not retrieved correctly");
		Mockito.when(mockUserService.getAUserByUserName("Bobuser")).thenReturn(new User(1L, "Bobuser", "user", 1));

		Assertions.assertEquals(mockUserService.getAUserByUserName("Bobuser").getUsername(), "Bobuser",
				"The username was not retrieved correctly");
	}
	
	
	
	

}
