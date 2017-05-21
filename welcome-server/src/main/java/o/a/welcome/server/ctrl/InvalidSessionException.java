package o.a.welcome.server.ctrl;

public class InvalidSessionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3710240294297152486L;
	
	public InvalidSessionException() {
		super("No session available with this token.");
	}

}
