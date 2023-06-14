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

// This class handles node creation for the stack
public class Node {

	protected Object item; 	// Object param
	protected Node next;	// Node param

	/*
	 * Description:		Instantiates a node, sets next to null
	 * Precondition: 	Object item is passed in
	 * Postcondition: 	New node, with null next node.
	 */
	Node(Object item) {
		this.item = item;
	    this.next = null;
	}

	/*
	 * Description:		Sets a new node with an object, and a next node
	 * Precondition: 	Object param and node param passed in
	 * Postcondition:  	Node is added
	 */
	Node(Object item, Node next) {
		this.item = item;
		this.next = next;
	}

}