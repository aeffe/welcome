package o.a.welcome.server.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Session {
	
	@Id
	private String token;
	
	@OneToOne
	private User user;
	
	@Column(nullable=false)
	private Date lastSeen;

	public Session() {
		super();
		this.lastSeen = new Date();
		this.token = UUID.randomUUID().toString();
	}

	public User getUser() {
		return user;
	}

	public Session setUser(User user) {
		this.user = user;
		return this;
	}

	public String getToken() {
		return token;
	}

	public Date getLastSeen() {
		return lastSeen;
	}
	
	public void touch() {
		this.lastSeen = new Date();
	}
}
