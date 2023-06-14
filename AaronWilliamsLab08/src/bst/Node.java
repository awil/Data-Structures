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

public class Node<T> {
	
	protected T item;		// do not change from protected
	protected Node<T> left;	// do not change from protected
	protected Node<T> right;// do not change from protected
	/*
	 * Description:	Node constructor
	 * Precondition: Item passed
	 * Postcondition: Item created
	 */
	public Node(T item) {
		this.item = item;
		this.left  = null;
		this.right = null;
	}
	/*
	 * Description:	Node constructor with left node & right node
	 * Precondition: The item, left, right nodes passed in
	 * Postcondition: New node is created
	 */
	public Node(T item, Node<T> left, Node<T> right) {
		this.item = item;
		this.left = left;
		this.right = right;
	}	

}
