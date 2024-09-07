package cbook;

public class SameContactException extends Exception {

	private static final String MESSAGE = "Contact already exists.";
	public SameContactException() {
	super(MESSAGE);	
	}
}
