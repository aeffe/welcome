package o.a.welcome.server.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import o.a.welcome.server.dao.UserSessionDao;
import o.a.welcome.server.dao.UserDao;
import o.a.welcome.server.dto.LoginDto;
import o.a.welcome.server.dto.UserDto;
import o.a.welcome.server.model.UserSession;
import o.a.welcome.server.model.User;

@Controller
@RequestMapping("/api/authentication")
public class AuthenticationController {
	
	@Autowired
	private UserDao _ud;
	
	@Autowired
	private UserSessionDao _sd;
	
	@CrossOrigin(
				origins = { "*" }
			,	allowedHeaders = {
						"X-Authentication"
					,	"Content-Type"
					,	"Accept"
					,	"Access-Control-Allow-Origin"
					,	"Access-Control-Allow-Credentials"
					,	"Access-Control-Allow-Methods"
					,	"Access-Control-Max-Age"
					,	"Access-Control-Allow-Headers"
				}
			,	methods = {
						RequestMethod.OPTIONS
					,	RequestMethod.POST
					})
	@RequestMapping(
				method = RequestMethod.POST
			,	path = "/login"
			,	headers = {
						"Accept: application/json"
					,	"Content-Type: application/json"
		
			})
	@ResponseBody
	public UserDto login(
			@RequestBody LoginDto loginDto)
					throws InvalidUsernameOrPasswordException {
		
		User user = this._ud.findOne(loginDto.getUsername()).orElseThrow(() -> new InvalidUsernameOrPasswordException());
		
		if (user.matchPassword(loginDto.getPassword())) {
			UserSession session = _sd.create()
					.setUser(user);
			this._sd.save(session);
			return user.extractDto(session);
		} else {
			throw new InvalidUsernameOrPasswordException();
		}
	}
	
	@CrossOrigin(
			origins = { "*" }
			,	allowedHeaders = { "X-Authentication" }
			,	methods = {
						RequestMethod.OPTIONS
					,	RequestMethod.GET
				})
	@RequestMapping(
				method = RequestMethod.GET
			,	path = "/logout" )
	@ResponseBody
	public void logout(
			@RequestHeader("X-Authentication") String token)
					throws InvalidSessionException {
		
		UserSession session = this._sd.findOne(token).orElseThrow(() -> new InvalidSessionException());
		this._sd.delete(session);
	}

}
