package cbook;

public class InexistentContactException extends Exception {

	private static final String MESSAGE = "Contact does not exist.";
	
	public InexistentContactException() {
		super(MESSAGE);
	}
}
