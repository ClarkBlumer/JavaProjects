/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		11.4.2014
 * Section:		C
 * Lab Code: 	I dont care
 */

package cjbq4f.cs3330.lab8;

@SuppressWarnings("serial")
public class InvalidBalanceException extends RuntimeException {

	public InvalidBalanceException() {
		
	}
	
	/**
	 * 
	 * @param exception passed String message about the exception that passes that up to the
	 * superclass to display to screen.
	 */
	public InvalidBalanceException(String exception) {
		super(exception);
	}
}
