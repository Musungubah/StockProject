package bmm.arsenal.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bmm.arsenal.demo.model.PasswordVerify;
import bmm.arsenal.demo.model.User;
import bmm.arsenal.demo.service.UserService;

@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public void signUp(@RequestBody PasswordVerify userVerify) {
		
//		System.out.println("This is about to create a user: " + userVerify.getUsername());
		
		userVerify.printUserinfo();
		
		User user = new User(userVerify.getUsername(),userVerify.getPassword(),1);
		userService.createAUser(user);
	}
	
	
	
	@PostMapping("/authenticate")
	public  boolean checkValidUser(@RequestBody PasswordVerify userVerify) {
		
		System.out.println(userVerify.getPassword());
		String name = userVerify.getUsername();
		User user = userService.getAUserByUserName(name);
		if(user.equals(null)) {
			return false;
		}
		
		if(user.getUsername().equals(userVerify.getUsername()) &&
				user.getPassword().equals(userVerify.getPassword())) {
			return true;
		}
		
		return false;
	}

}