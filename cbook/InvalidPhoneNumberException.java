package cbook;

public class InvalidPhoneNumberException extends Exception {

	private static final String MESSAGE = "Not a valid phone number.";
	
	public InvalidPhoneNumberException() {
		super(MESSAGE);
	}
}
