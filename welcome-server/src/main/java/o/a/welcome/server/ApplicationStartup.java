package o.a.welcome.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import o.a.welcome.server.dao.UserDao;
import o.a.welcome.server.model.User;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
	
	@Autowired
	private UserDao _ud;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		User user = this._ud.findOne("admin")
			.orElse(_ud.create()
					.setUsername("admin")
					.setPassword("welcomeadmin")
					.setEmailAddress("admin@admin.com"));
		
		_ud.save(user);
		
		
	}

}
