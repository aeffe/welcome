package o.a.welcome.server.dto;

public class UserDto {
	
	private String username;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String token;
	
	public UserDto(
			String username,
			String firstName,
			String lastName,
			String emailAddress,
			String token) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getToken() {
		return token;
	};
	
}
