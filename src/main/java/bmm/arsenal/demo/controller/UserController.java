package bmm.arsenal.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import bmm.arsenal.demo.model.User;
import bmm.arsenal.demo.repository.UserRepository;
import bmm.arsenal.demo.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	

	
	@GetMapping
	@ResponseBody
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping(path="/{id}")
	public Optional<User> getAUserById(@PathVariable Long id) {
		return userService.getUserById(id);
		
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder uri) {
		User userCreate = new User(user.getUsername(),user.getPassword(),user.getEnabled());
		userService.createAUser(userCreate);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(userCreate.getId()).toUri();
		ResponseEntity<?> response=ResponseEntity.created(location).build();
		return response;
		
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteAUser(@PathVariable Long id) {
		userService.deleteUser(id);
		
	}
	
	


}
