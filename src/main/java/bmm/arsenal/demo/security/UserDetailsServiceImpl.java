package bmm.arsenal.demo.security;

import bmm.arsenal.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import bmm.arsenal.demo.model.User;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository applicationUserRepository) {
        this.userRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
    	//System.out.println("Looking for the username: " + username);
        User applicationUser = userRepository.findByusername(username);
        UserBuilder builder = null;
        
        if (applicationUser == null) {
        	//System.out.println("User doesn't exist at all!!!s");
            return null;
        }
        
        
        //System.out.println("Createing user detail service");
        //String[] emptyArray = null;
        
        builder = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(new BCryptPasswordEncoder().encode(applicationUser.getPassword()));
        builder.roles(applicationUser.getRoles());
        
        if(!builder.build().isEnabled()) {
        	throw new UsernameNotFoundException("User is not enabled" );
        }
        return builder.build();
        
       // return new User(applicationUser.getUsername(), applicationUser.getPassword());
    }
}