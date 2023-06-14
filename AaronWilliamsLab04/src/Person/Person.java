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
package Person;

public class Person {

	private int ID; // ID of the person
	private String name; // Person's name
	
	/*
	 * Description:	default constructor method, sets person with ID and name
	 * Precondition: int ID, String name
	 * Postcondition: person object was created with ID & name
	 */
	public Person(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}
	
	/*
	 * Description:	returns the ID of the specified person
	 * Precondition: method called
	 * Postcondition: return the ID
	 */
	public int getID() {
		return this.ID;
	}
	
	/*
	 * Description:	returns the name of the specified person
	 * Precondition: method called
	 * Postcondition: return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * Description:	this method tests to see if the object is equal to the person
	 * Precondition: object param passed
	 * Postcondition: returns false if not equal, true if it is equal
	 */
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Person)) {
			return false;
		} else if(o == this) {
			return true;
		} 

		Person p = (Person) o;
		return (this.ID == p.ID && this.name.equals(p.name));
	}
	
}
