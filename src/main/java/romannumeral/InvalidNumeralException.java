package romannumeral;

@SuppressWarnings("serial")
public class InvalidNumeralException extends RuntimeException {
	public InvalidNumeralException() {
		super();
	}

	public InvalidNumeralException(String message) {
		super(message);
	}

	public InvalidNumeralException(String formatString, Object... args) {
		super(String.format(formatString, args));
	}
}
