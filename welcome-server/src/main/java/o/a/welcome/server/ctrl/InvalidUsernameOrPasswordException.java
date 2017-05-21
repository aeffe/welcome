package o.a.welcome.server.ctrl;

public class InvalidUsernameOrPasswordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6303666406790520460L;
	
	public InvalidUsernameOrPasswordException() {
		super("Invalid username or password: login failed!");
	}

}
