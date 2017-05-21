package o.a.welcome.server.repo;

import org.springframework.data.repository.CrudRepository;

import o.a.welcome.server.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
