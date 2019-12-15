package bmm.arsenal.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import bmm.arsenal.demo.model.User;
import bmm.arsenal.demo.repository.UserRepository;



@Service
public class UserService  {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService() {
		super();
	}
	
	public UserService(UserRepository userRepo) {
		super();
		this.userRepository = userRepo;
		
	}
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	public User getAUserByUserName(String username) {
		return userRepository.findByusername(username);
	}
	
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}
	
	public void deleteUser(String username) {
		userRepository.deleteById(userRepository.findByusername(username).getId());
	}
	
	public void editUserInfoPassword(User user) {
		User editUser = userRepository.findByusername(user.getUsername());
		editUser.setPassword(user.getPassword());
		userRepository.save(editUser);
	}
	
	public void createAUser(User user) {
		User newUser = new User(user.getUsername(),user.getPassword(),user.getEnabled());
		userRepository.save(newUser);
	}
	

	
	public void deleteUser(User user) {
		userRepository.deleteById(user.getId());
	}
	

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	


}


