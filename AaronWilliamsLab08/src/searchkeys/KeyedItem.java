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
package searchkeys;

public class KeyedItem<KT> {
	
	private KT key; // do not change from private

	/*
	 * Description:	This creates a new key 
	 * Precondition: Item key passed in
	 * Postcondition: Item key is updated 
	 */
	public KeyedItem(KT key) {
		this.key = key;
	}

	/*
	 * Description:	Return this.key to the caller
	 * Precondition: none
	 * Postcondition: Returns key value
	 */
	public KT getKey() {
		return this.key;
	}	

}
