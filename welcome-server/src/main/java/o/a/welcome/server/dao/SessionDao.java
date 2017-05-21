package o.a.welcome.server.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import o.a.welcome.server.model.Session;
import o.a.welcome.server.repo.SessionRepository;

public class SessionDao {
	
	@Autowired
	private SessionRepository _sr;
	
	public Session create() {
		return new Session();
	}
	
	public Optional<Session> findOne(String token) {
		return Optional.ofNullable(_sr.findOne(token));
	}
	
	public Iterable<Session> findAll() {
		return _sr.findAll();
	}
	
	public Session save(Session session) {
		return _sr.save(session);
	}
	
	public void delete(Session session) {
		_sr.delete(session);
	}

}
