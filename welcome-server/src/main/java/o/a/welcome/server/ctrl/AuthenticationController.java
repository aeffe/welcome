package o.a.welcome.server.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import o.a.welcome.server.dao.SessionDao;
import o.a.welcome.server.dao.UserDao;
import o.a.welcome.server.dto.LoginDto;
import o.a.welcome.server.dto.UserDto;
import o.a.welcome.server.model.Session;
import o.a.welcome.server.model.User;

@Controller
@RequestMapping("/api/authentication")
public class AuthenticationController {
	
	@Autowired
	private UserDao _ud;
	
	@Autowired
	private SessionDao _sd;
	
	@RequestMapping(method=RequestMethod.POST, path="/login")
	public UserDto login(
			@RequestBody LoginDto loginDto)
					throws InvalidUsernameOrPasswordException {
		
		User user = this._ud.findOne(loginDto.getUsername()).orElseThrow(() -> new InvalidUsernameOrPasswordException());
		
		if (user.matchPassword(loginDto.getPassword())) {
			Session session = _sd.create()
					.setUser(user);
			this._sd.save(session);
			return user.extractDto(session);
		} else {
			throw new InvalidUsernameOrPasswordException();
		}
	}
	
	@RequestMapping(path="/logout", method=RequestMethod.GET)
	public void logout(
			@RequestHeader("X-Authentication") String token)
					throws InvalidSessionException {
		
		Session session = this._sd.findOne(token).orElseThrow(() -> new InvalidSessionException());
		this._sd.delete(session);
	}

}
