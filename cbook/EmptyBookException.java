package cbook;

public class EmptyBookException extends Exception {
	
	public static final String MESSAGE = "Contact book empty.";
	
	public EmptyBookException() {
		super(MESSAGE);
	}
}
