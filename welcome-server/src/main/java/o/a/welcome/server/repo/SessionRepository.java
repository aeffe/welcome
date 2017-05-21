package o.a.welcome.server.repo;

import org.springframework.data.repository.CrudRepository;

import o.a.welcome.server.model.Session;

public interface SessionRepository extends CrudRepository<Session, String> {

}
