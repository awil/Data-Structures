/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 9
 * Date started:	October 27, 2022
 * Date finished:	October 29, 2022
 * Description:		This program works with priority queues, min/max heaps.
 */
package items;

public class Node extends KeyedItem<Integer>{

	/*
	 * Description:	Node constructor for integer objects
	 * Precondition: Item passed
	 * Postcondition: Item created
	 */
	public Node(Integer key) {
		super(key);
	}
	
	/*
	 * Description:	Node getter for integer key
	 * Precondition: None
	 * Postcondition: Returns key
	 */
	public Integer getKey() {
		return super.getKey();
	}
	
	/*
	 * Description:	Node setter for integer key
	 * Precondition: None
	 * Postcondition: Sets key
	 */
	public void setKey(Integer key) {
		super.setKey(key);
	}

}
