package bmm.arsenal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bmm.arsenal.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByusername(String username);
	public User deleteByusername(String username);
	//public String 
}
