/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 5
 * Date started:	September 13, 2022
 * Date finished:	September 18, 2022
 * Description:		This project converts infix expressions to postfix.
 */
package stack;

// This class handles exceptions for the stack
public class StackException extends RuntimeException {

	private static final long serialVersionUID = 8052979378365919409L;

	/*
	 * Description:	
	 * Precondition: 
	 * Postcondition: 
	 */
	public StackException(String s) {
		super(s);
	}
	
}
