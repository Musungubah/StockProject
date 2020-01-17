package bmm.arsenal.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

import bmm.arsenal.demo.controller.UserController;
import bmm.arsenal.demo.model.User;
import bmm.arsenal.demo.service.UserService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {
	
		@Autowired
	    private MockMvc mvc;
	 
	    @MockBean
	    private UserService service;

		@Test
		void testController() {
			User alex = new User("bmusungu","pass",4);
			 
		    List<User> allUser = Arrays.asList(alex);
		    BDDMockito.given(service.getAllUser()).willReturn(allUser);
		 
		    
		    try {
				mvc.perform(get("/")
				  .contentType(MediaType.APPLICATION_JSON))
				  .andExpect(status().isOk())
				  .andExpect(jsonPath("$", hasSize(1)))
				  .andExpect(jsonPath("$[0].username", is(alex.getUsername())));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		void testUserPresent() {
//			User alex = new User("alex","pass",4);
//			User tre =  new User("tre","pass",4);
//			User ben =  new User("ben","pass",4);
//			
//		    List<User> allUser = Arrays.asList(alex, tre, ben);
//		    BDDMockito.given(service.getAllUser()).willReturn(allUser);
//		    
//		    
		    
		}

}
