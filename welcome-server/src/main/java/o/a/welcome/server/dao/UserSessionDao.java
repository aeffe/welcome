package o.a.welcome.server.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import o.a.welcome.server.model.UserSession;
import o.a.welcome.server.repo.SessionRepository;

@Component
public class UserSessionDao {
	
	@Autowired
	private SessionRepository _sr;
	
	public UserSession create() {
		return new UserSession();
	}
	
	public Optional<UserSession> findOne(String token) {
		return Optional.ofNullable(_sr.findOne(token));
	}
	
	public Iterable<UserSession> findAll() {
		return _sr.findAll();
	}
	
	public UserSession save(UserSession session) {
		return _sr.save(session);
	}
	
	public void delete(UserSession session) {
		_sr.delete(session);
	}

}
