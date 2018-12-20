package by.gsu.pms.exceptions;

public class NoSuchUserException extends Exception {

	private static final long serialVersionUID = 7825588148537575642L;

	public NoSuchUserException() {
		super();
	}

	public NoSuchUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchUserException(String message) {
		super(message);
	}

	public NoSuchUserException(Throwable cause) {
		super(cause);
	}
	
}
