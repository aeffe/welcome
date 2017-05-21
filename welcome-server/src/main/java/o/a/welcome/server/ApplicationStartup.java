package o.a.welcome.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import o.a.welcome.server.model.User;
import o.a.welcome.server.repo.UserRepository;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
	
	@Autowired
	private UserRepository _ur;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		User user = this._ur.findOne("admin");
		
		if (user == null) {
			System.out.println("Default administration user does not exists: creating...");
			user = new User("admin", "John", "The Administrator", "admin@admin.com", "welcomeadmin");
			_ur.save(user);			
		} else {
			System.out.println("Default administration user already created.");
		}
		
	}

}
