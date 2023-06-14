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
package driver;

import searchkeys.KeyedItem;

public class Item extends KeyedItem<Integer> {
	
	public String fname;
	public String lname;

	/*
	 * Description:	Instantiate item with passed values
	 * Precondition: Key, First Name, & Last Name are passed
	 * Postcondition: Item created with key
	 */
	public Item(Integer key, String fname, String lname) {
		super(key);
		this.fname = fname;
		this.lname = lname;
	}
	
	/*
	 * Description:	Returns STring first name
	 * Precondition: none
	 * Postcondition: String is returned with fname
	 */
	public String getfname() {
		return this.fname;
	}
	
	/*
	 * Description:	Returns string last name
	 * Precondition: none
	 * Postcondition: String is returned with lname
	 */
	public String getlname() {
		return this.lname;
	}	
	
	/*
	 * Description:	Returns a formatted string with the items
	 * Precondition: none
	 * Postcondition: String formatted nicely with Key, Fname, Lname
	 */
	@Override
	public String toString() {
	    return String.format("\n%3d %-10s %-10s", this.getKey(), this.fname, this.lname);
	}


}
