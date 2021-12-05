package edu.mtc.egr281.project15;

public class UnKnownColorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UnKnownColorException(String newMessage) {
		super(newMessage);
	} // constructor
	
	public UnKnownColorException() {
		this("UnKnown Color");
	} // constructor
} // class
