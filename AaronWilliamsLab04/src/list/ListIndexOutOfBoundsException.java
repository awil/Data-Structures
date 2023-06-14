/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 4
 * Date started:	September 7, 2022
 * Date finished:	September 11, 2022
 * Description:		This project works with abstract data types and manipulates
 * 					a linked list.
 */
package list;


public class ListIndexOutOfBoundsException extends IndexOutOfBoundsException {

	private static final long serialVersionUID = -9065852573163344398L; 
	
	/*
	 * Description:	throws IndexOutOfBoundsException
	 * Precondition: exception
	 * Postcondition: exception was thrown
	 */
	public ListIndexOutOfBoundsException(String s) {
		super(s);
	}

}
