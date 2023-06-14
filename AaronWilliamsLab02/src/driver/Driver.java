/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 2
 * Date started:	August 24, 2022
 * Date finished:	August 27, 2022
 * Description:		This lab is a program using recursion to figure out the reproduction
 * 					rates of tribbles, future value of a principle amount using simple interest,
 * 					and the future value of a principle amount using compounding interest.
 */
package driver;

import java.util.Scanner;

import recursion.Recursion;

// The Driver class initiates the program, retrieves user input,
// and passes into Recursion for calculations
public class Driver {
	
	/*
	 * Description:		Main method to call the recursion methods
	 * Precondition:	None
	 * Postcondition:	Results are printed using the input parameters from the user 
	 */
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in); // Scanner for user input
		Recursion recursion = new Recursion(); // Declare/instantiate new Recursion object
		
		System.out.print("Days? ");
		int days = scnr.nextInt(); // Integer amount of days 
		System.out.println(recursion.tribbles(days));
		
		System.out.print("P? ");
		double P = scnr.nextDouble(); 	// Principle amount (double)
		System.out.print("r? ");
		double r = scnr.nextDouble(); 	// Rate amount (double)
		System.out.print("n? ");
		int n = scnr.nextInt();  		// Period amount in months (integer)
		System.out.println("V= " + recursion.V(P, r, n));
		
		System.out.print("P? ");
		P = scnr.nextDouble(); 		// Principle amount (double)
		System.out.print("r? "); 
		r = scnr.nextDouble(); 		// Rate amount (double)
		System.out.print("n? ");
		n = scnr.nextInt();			// Period amount in months (integer)
		System.out.println("A= " + recursion.A(P, r, n));
		
		scnr.close(); // Close the scanner
	}	
	
}
