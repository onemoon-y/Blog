package blog.xy.utils;

public class FailException extends Exception {

	public FailException() {

	}

	public FailException(String message) {
		super(message);
	}

	public FailException(Throwable cause) {
		super(cause);
	}

	public FailException(String message, Throwable cause) {
		super(message, cause);
	}

	public FailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
