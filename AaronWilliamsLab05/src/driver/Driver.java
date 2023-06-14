/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 5
 * Date started:	September 13, 2022
 * Date finished:	September 18, 2022
 * Description:		This project converts infix expressions to postfix.
 */
package driver;

// This class drives the program
public class Driver {
	/*
	 * Description:	main driving method for the package
	 * Precondition: None
	 * Postcondition: infix expression converted to postfix
	 */
	public static void main(String[] args) {
		Expressions converter = new Expressions();  // Instantiate expressions for testing
		String infix = "x*(y/(5*z))+(2)"; 			// Expression to test
		String postfix = "xy5z*/*2+";
        
//        System.out.println(converter.checkbalance(infix)); // Convert to postfix
//        // If the expression is balanced, convert to postfix
//        if (converter.checkbalance(infix)) {
//        	// Convert and print output
//        	System.out.println(converter.infixToPostfix(infix));
//        } // end if
        System.out.println(postfix);
        System.out.println(converter.postfixToInfix(postfix));
        System.out.println(infix);
	}
}
