/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 8
 * Date started:	October 16, 2022
 * Date finished:	October 22, 2022
 * Description:		This program deals with Binary Search Trees and their
 * 					manipulations.
 */
package bst;

public class BSTException extends Exception {
	
	private static final long serialVersionUID = -4980084404399396750L;
	/*
	 * Description:	Handles thrown exceptions
	 * Precondition: String passed in for BSTException value
	 * Postcondition: Returned exception
	 */
	public BSTException(String s) {
		super(s);
	}
}
