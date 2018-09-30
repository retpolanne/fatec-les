package exceptions;

public class UnauthorizedUserException extends Exception {
    public UnauthorizedUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnauthorizedUserException(String message) {
		super(message);
	}

	public UnauthorizedUserException(Throwable cause) {
		super(cause);
	}
}