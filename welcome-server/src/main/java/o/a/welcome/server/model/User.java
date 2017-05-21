package o.a.welcome.server.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import o.a.welcome.server.dto.UserDto;

@Entity
public class User {
	
	static private MessageDigest md;
	
	{
		try { 
			User.md = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException nsae) {
			System.out.println(nsae);
		}
	}
	
	public User() {
		super();
	}
	
	public User(String username, String firstName, String lastName, String emailAddress, String password) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.setPassword(password);
	}
	
	@Column(nullable=false)
	@Id
	private String username;
	
	@Column(nullable=true)
	private String firstName;
	
	@Column(nullable=true)
	private String lastName;
	
	@Column(nullable=false)
	private String emailAddress;
	
	@Column(nullable=false)
	private String password;

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public User setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}

	public boolean matchPassword(String password) {
		return this.password.equals(new String(md.digest(password.getBytes())));
	}

	public User setPassword(String password) {
		this.password = new String(md.digest(password.getBytes()));
		return this;
	}
	
	public UserDto extractDto(Session session) {
		
		return new UserDto(
				this.username,
				this.firstName,
				this.lastName,
				this.emailAddress,
				session.getToken());
	}
	
	

}
