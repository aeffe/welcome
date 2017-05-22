package o.a.welcome.server.repo;

import org.springframework.data.repository.CrudRepository;

import o.a.welcome.server.model.UserSession;

public interface SessionRepository extends CrudRepository<UserSession, String> {

}
