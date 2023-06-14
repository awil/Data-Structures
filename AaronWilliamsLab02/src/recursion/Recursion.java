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

package recursion;

//The Recursion class calculates the multiplying Tribbles, simple interest, and compound interest inputs
public class Recursion {
	
	/*
	 * Description:		This is the tribbles method that calculates the multiplying bebes
	 * Precondition:	The number of days should be specified
	 * Postcondition:	The total number of tribbles expected 
	 */
	public int tribbles(int days) {
		if (days <= 1) {
			return 1;	// If there has only been one day, only return one tribble.
		} else if (days % 2 == 0) {	// If there's an even day, the tribble should birth four
			return tribbles(days - 1) + (4 * tribbles(days-1)); // Add four tribbles to the family
		}
		else {	// If it's not an even day, the tribble will birth three
			return tribbles(days - 1) + (3 * tribbles(days-1)); // Add three tribbles to the family
		}
		
	}
	
	/*
	 * Description:		This is a method to calculate simple interest 
	 * 					(Basically adds the same interest every month)
	 * Precondition:	P, r, n are provided by the initiating code.
	 * Postcondition:	Return total amount of Principle + Simple Interest for specified periods
	 */
	public double V(double P, double r, int n) {
		if (n <= 0) { 
			return P; // If period is 0, nothing is increased, return Principle
		} else {
			return ((P * (r/12)) / 100) + V(P,r,n-1); // Calculate simple interest and add to the total value, return the total
		}
	}
	
	/*
	 * Description:		This is a method to calculate compounding interest/future value
	 * 					(Calls the V() method to calculate the compounding interest)
	 * Precondition:	P, r, n are provided by the initiating code and V() is functioning properly.
	 * Postcondition:	Return future value of the principle with the compounding interest.
	 */
	public double A(double P, double r, int n) {
		if (n <= 0) { 
			return P; // If period is 0, nothing is increased, return Principle
		} else {
			// We can get the Future Value by calling V() within A() to calculate the compounding interest—
			// recursion inception, if you will. (ha) Since compounding interest is basically just 
			// simple interest, you're just updating the principle each time instead of using the original
			// principle amount. 
			return  A(V(P, r, 1),r,n-1);
		}
	}
}
