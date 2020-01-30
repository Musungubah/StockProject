package bmm.arsenal.demo.security;



import com.auth0.jwt.JWT;

import com.fasterxml.jackson.databind.ObjectMapper;

import bmm.arsenal.demo.model.PasswordVerify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.validation.ObjectError;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static bmm.arsenal.demo.security.SecurityConstants.EXPIRATION_TIME;
import static bmm.arsenal.demo.security.SecurityConstants.HEADER_STRING;
import static bmm.arsenal.demo.security.SecurityConstants.SECRET;
import static bmm.arsenal.demo.security.SecurityConstants.TOKEN_PREFIX;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	

	
	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
		
		
        try {
        	
            PasswordVerify creds = new ObjectMapper()
            				.readValue(req.getInputStream(), PasswordVerify.class);
            
            
            ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            UsernamePasswordAuthenticationToken op = new UsernamePasswordAuthenticationToken(
                    creds.getUsername(),
                    creds.getPassword(), authorities);
            
    
           
            
            return authenticationManager.authenticate(op);
          
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (AuthenticationException e) {
        	throw new RuntimeException(e);
        }
        
		
    }
	
	 @Override
	    protected void successfulAuthentication(HttpServletRequest req,
	                                            HttpServletResponse res,
	                                            FilterChain chain,
	                                            Authentication auth) throws IOException, ServletException {

		 
		 System.out.println("Successful authentication of the server!!!" + "\n" + auth.getPrincipal().toString());
	        String token = JWT.create()
	                .withSubject(auth.getPrincipal().toString())
	                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
	                .sign(HMAC512(SECRET.getBytes()));
	        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
	        res.addHeader("Access-Control-Allow-Headers", "Authorization, X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept, X-Custom-header");
	        
	        System.out.println(res.toString());
	        
	    }

}
