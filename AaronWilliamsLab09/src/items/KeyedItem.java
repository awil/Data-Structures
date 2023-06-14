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

public abstract class KeyedItem<KT extends Comparable<? super KT>> {
  
	private KT key;

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

	/*
	 * Description:	Sets the key
	 * Precondition: none
	 * Postcondition: Key has been set
	 */
	public void setKey(KT key) {
		this.key = key;
	}
	
}