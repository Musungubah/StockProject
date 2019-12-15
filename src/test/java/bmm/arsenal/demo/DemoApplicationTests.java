package bmm.arsenal.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import bmm.arsenal.demo.model.User;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testUserCreation() {
		
		User userTest = new User(1L,"bmusungu","pass",1);
		assertNotNull(userTest);
		
		assertEquals(userTest.getUsername(), "bmusungu");
	}

}
