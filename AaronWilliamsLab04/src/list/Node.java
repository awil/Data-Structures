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

public class Node {
	
	protected Object item; // Object to represent item
	protected Node next;	// Node to represent the linked node
	
	/*
	 * Description:	This is the constructor method for a node
	 * Precondition: Object param
	 * Postcondition: Node has been created with null next
	 */
	Node(Object newItem) {
		item = newItem;
		next = null;
	}
	
	/*
	 * Description:	This is another constructor method for a node
	 * Precondition: Object param, next specified
	 * Postcondition: Node has been created with the specified next
	 */
	Node(Object newItem, Node next) {
		item = newItem;
		this.next = next;
	}

}
