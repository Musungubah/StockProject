package bmm.arsenal.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import bmm.arsenal.demo.model.User;

class ModelsTest {

	@Test
	void testUserCreation() {
		User myUser = new User("Bryan","pass", 1);
		
		
		assertNotNull(myUser);
		
		
		BCryptPasswordEncoder passwordConverter = new BCryptPasswordEncoder();
		User myUser2 = new User("Bubba",passwordConverter.encode("pass"),1);
		
		assertNotNull(myUser2);
	}

}
