/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 6
 * Date started:	September 19, 2022
 * Date finished:	September 24, 2022
 * Description:		This project converts infix expressions to postfix using queues.
 */
package queue;

// QueueException class handles exceptions for the queue
public class QueueException extends RuntimeException {

	private static final long serialVersionUID = 8513121132880862866L;

	// Method passes the exception message to the super
	public QueueException(String s) {
		super(s);
	}
	
}