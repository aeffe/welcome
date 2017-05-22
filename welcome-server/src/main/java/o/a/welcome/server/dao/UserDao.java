package o.a.welcome.server.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import o.a.welcome.server.model.User;
import o.a.welcome.server.repo.UserRepository;

@Component
public class UserDao {
	
	@Autowired
	private UserRepository _ur;
	
	public User create() {
		return new User();
	}
	
	public Optional<User> findOne(String username) {
		return Optional.ofNullable(_ur.findOne(username));
	}
	
	public Iterable<User> findAll() {
		return _ur.findAll();
	}
	
	public User save(User user) {
		return _ur.save(user);
	}
	
	public void delete(User user) {
		_ur.delete(user);
	}

}
