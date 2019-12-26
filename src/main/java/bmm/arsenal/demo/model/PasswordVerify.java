package bmm.arsenal.demo.model;

import org.springframework.stereotype.Component;

@Component
public class PasswordVerify {
	
	public String username;
	public String password;
	
	
	public PasswordVerify(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public PasswordVerify() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void printUserinfo() {
		System.out.println("This is the username: " + this.getUsername() + "\n This password: " + this.getPassword() );
	}
	
}
