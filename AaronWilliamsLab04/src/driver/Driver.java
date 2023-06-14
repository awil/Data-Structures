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
package driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import Person.Person;
import list.RList;

public class Driver {
	/*
	 * Description:	main driving method for the package
	 * Precondition: Text file with names exists
	 * Postcondition: The data is manipulated and displayed
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("files/people.txt"); // Text file for input
		Scanner scnr = new Scanner(file); // Scnr to read contents
		RList people = new RList(); // New ADT of RList 
		
		// Read contents of the file
		while(scnr.hasNext()) {
			int ID = scnr.nextInt();
			String name = scnr.next();
			// Form person object from each line
			Person p = new Person(ID, name); 
			// Add person to the list of people
			people.add(people.size(), p);
		}
		
		// Close the scanner
		scnr.close();		

		
		// Display the original list of people
		System.out.println("This is the original list: ");
		for (int i = 0; i < people.size(); i++) {
			Person p = (Person) people.get(i);
			System.out.println(i + " " + p.getID() + " " + p.getName() + " ");
		} System.out.println("");
		
		// Comparison test, we want to see that it matches
		Person per = new Person(46952, "Gilberto");
		people.testComparison(per);
		
		// Add two people
		Person t = new Person(15523, "Generic");
		people.add(t);
		Person r = new Person(16071, "Aaron");
		people.add(r);
		// Display the original list of people
		System.out.println("\nAdded two people using add():\n");
		for (int i = 0; i < people.size(); i++) {
			Person p = (Person) people.get(i);
			System.out.println(i + " " + p.getID() + " " + p.getName() + " ");
		} System.out.println("");

		// Add a person to the front
		Person q = new Person(55112, "Sean");
		people.addFirst(q);
		
		// Display the list of nodes
		people.display();
		
		// Display the list of people
		System.out.println("");
		for (int i = 0; i < people.size(); i++) {
			Person p = (Person) people.get(i);
			System.out.println(i + " " + p.getID() + " " + p.getName() + " ");
		}

		// Index of a person
		Person ex = (Person) people.get(16);
		System.out.println("\n\nFind indexOf(" + ex.getID() + " " + ex.getName() + ")");
		System.out.println("Index of: " + people.indexOf(people.get(16)) + "\n");

		// Find last index of
		Person es = (Person) people.get(7);
		System.out.println("Get lastIndexOf(" + es.getID() + " " + es.getName() + ")");
		System.out.println("lastIndexOf: " + people.lastIndexOf(people.get(7)) + "\n");
		
		// Remove this person
		System.out.println("\nremove(" + es.getID() + " " + es.getName() + ")\n");
		people.remove(es);
		for (int i = 0; i < people.size(); i++) {
			Person p = (Person) people.get(i);
			System.out.println(i + " " + p.getID() + " " + p.getName() + " ");
		}
		
		// Remove the last person in the list
		people.removeLast();
		System.out.println("\n\nremoveLast():\n");
		for (int i = 0; i < people.size(); i++) {
			Person p = (Person) people.get(i);
			System.out.println(i + " " + p.getID() + " " + p.getName() + " ");
		}
		
		// Remove the last instance of this person
		Person z = new Person(49015, "Charlene");
		System.out.println("\n\nremoveLast(" + z.getID() + " " + z.getName() + ")\n");
		people.removeLast(z);
		for (int i = 0; i < people.size(); i++) {
			Person p = (Person) people.get(i);
			System.out.println(i + " " + p.getID() + " " + p.getName() + " ");
		}
				
		// Remove all instances of this person
		Person c = new Person(24066, "Gerald");
		System.out.println("\n\nremoveAll(" + c.getID() + " " + c.getName() + ")\n");
		people.removeAll(c);
		for (int i = 0; i < people.size(); i++) {
			Person p = (Person) people.get(i);
			System.out.println(i + " " + p.getID() + " " + p.getName() + " ");
		}
			
				
		// Set index to the specified person
		Person g = new Person(55555, "Blank");
		System.out.println("\n\nset(" + ((Person) people.get(15)).getID() + " " + ((Person) people.get(15)).getName() +
				", " + g.getID() + " " + g.getName() + ")\n");
		people.set(15, g);
		for (int i = 0; i < people.size(); i++) {
			Person p = (Person) people.get(i);
			System.out.println(i + " " + p.getID() + " " + p.getName() + " ");
		}
		
		// Add duplicates to the list to test setAll
		System.out.println("\n\nAdding duplicates...\n");
		people.set(3, r); 
		people.set(5, r); 
		people.set(7, r);
		for (int i = 0; i < people.size(); i++) {
			Person p = (Person) people.get(i);
			System.out.println(i + " " + p.getID() + " " + p.getName() + " ");
		}
		
		// setAll to the referenced person
		System.out.println("\n\nsetAll(" + r.getID() + " " + r.getName() +
				", "+ c.getID() + " " + c.getName() + ")\n");
		people.setAll(r, c);
		for (int i = 0; i < people.size(); i++) {
			Person p = (Person) people.get(i);
			System.out.println(i + " " + p.getID() + " " + p.getName() + " ");
		} System.out.println("\n\n");
		
		// Load all of people into an Object Array
		Object[] peeps = people.toArray();
		System.out.println(Arrays.toString(peeps));
		
		people.display();
	
	}

}
