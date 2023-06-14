/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 6
 * Date started:	September 19, 2022
 * Date finished:	September 24, 2022
 * Description:		This project converts infix expressions to postfix using queues.
 */
package driver;

//This class drives the program
public class Driver {
	
	/*
	 * Description:	This is the main driving method for the package
	 * Precondition: None
	 * Postcondition: infix expression converted to postfix using queues
	 */
	public static void main(String[] args) {
		Expressions converter = new Expressions(); // Instantiate expression for conversion
        String infix = "x*(y/(5*z))+(2)"; // Expression to convert
        
        // Check the balance of the parentheses 
        System.out.println(converter.checkbalance(infix));
        // If the expression is balanced, convert to postfix
        if (converter.checkbalance(infix)) {
        	// Convert and print output
        	System.out.println(converter.infixToPostfix(infix));
        } // end if

	}
	
}
