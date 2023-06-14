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

import stack.RStack;
import stack.StackException;

// This class handles an infix expression
public class Expressions {
	
	private RStack dooku; // Add a stack

	/*
	 * Description:		Instantiate the stack
	 * Precondition: 	None
	 * Postcondition: 	dooku (stack) is instantiated
	 */
	public Expressions() {
		dooku = new RStack();
	}
	
	/*
	 * Description:		This method checks to see if the infix is
	 * 					balanced. If it is, we'll return true
	 * Precondition: 	string param (infix)
	 * Postcondition: 	true or false, based on balanced parentheses
	 */
	public boolean checkbalance(String expression) {
		boolean isBal = true; // Boolean var for balance
		int i = 0; // Count
		
		// While isBal is true and the iterator is less than
		// the length, continue
		while (isBal && i < expression.length()) {
			char c = expression.charAt(i); // char c for cleaner code
			++i; // iterator
			
			// Push the open parenthesis
			if (c == '(') {
				dooku.push('(');
			}
			// Pop the close parenthesis
			else if (c == ')') {
				// Try to pop an open brace
				try {
					dooku.pop();
				}
				// If we can't pop, throws exception and return false
				catch (StackException e) {
					isBal = false;
				}
			} // end if
		} // end while
		
		if (isBal && dooku.isEmpty()) {
			// It's balanced
			return true;
		} else {
			// It's not balanced
			return false;
		} // end if
	}
	
	/*
	 * Description:		This method determines PEMDAS precedence 
	 * Precondition: 	char c param
	 * Postcondition: 	Returns precedence value
	 */
	public int precedence(char c) {
		
		// Determine precedence
		switch (c) {
			// Open parenthesis: return 0
			case '(':
				return 0;
			// Close parenthesis: return 1
			case ')':
				return 1;
			// Multiplication, division: return 2
			case '*':
			case '/':
				return 2;
			// Addition, subtraction: return 3
			case '+':
			case '-':
				return 3;
			// If for some reason there's other case: return -1
			default:
				return -1;
		} // end switch
	}
	
	/*
	 * Description:	This method tests the char c to make sure it's alphanumeric
	 * Precondition: char param
	 * Postcondition: Returns true if it's alphanumeric, false if it is not
	 */
    public boolean isOperand(char c)
    {
    	// Testing for alphanumeric characters
    	// If c is within the ranges of each set, it's an operand
    	if ((c >= '0' && c <= '9') || 		// Numerics
    			(c >= 'A' && c <= 'Z') ||	// Upper-case letters
    			(c >= 'a' && c <= 'z')) {	// Lower-case letters
    		return true;
    	} else {
    		return false;
    	} // end if
    }
    
    /*
	 * Description:		This method accepts an infix expression
	 * 					and converts it to postfix
	 * Precondition: 	string param of infix expression
	 * Postcondition: 	return string of postfix expression
	 */
    public String infixToPostfix(String infix)
    {
    	String postfix = ""; 	// Postfix expression string
    	dooku.popAll(); 		// Make sure the stack is clear
    	int pre; 				// Int to hold precedence
    	
    	for (int i = 0; i < infix.length(); i++) {
    		// Holding infix.charAt(i) for easier understanding code
    		char c = infix.charAt(i);
    		
    		// Check to see if 'c' (charAt(i)) is not an operand
    		if (!isOperand(c)) {
    			// get precedence so switch can determine which case it is
    			pre = precedence(c); 
    			
    			// Switch uses 'pre' to determine which case to handle the char,
    			// using the precedence value of open parenthesis,
    			// closing parenthesis, and operators
    			// 0: (
    			// 1: )
    			// 2, 3: * / + -
    			switch (pre) {
    				// Open Parenthesis
    				case 0:
    						// Push ( to the stack
	        				dooku.push(c);
    					break;
    				// Closing parenthesis
	        		case 1: 
        				// While the stack's not empty and the top isn't '('
        				// Pop the element to the postfix expression
        				while (!dooku.isEmpty() && (char)dooku.peek() != '(') {
        					postfix = postfix + dooku.pop();
        				} // end while
        				// Pop the remaining open parenthesis
        				dooku.pop();
	        			break;
	        		// Multiplication & Division
	        		case 2: 
	        		// Addition & Subtraction
	        		case 3:
	        			// While the stack's not empty and the top isn't '('
	        			// we want to pop the operators into the postfix expression
	        			// if the precedence of the operator(charAt(i)) is lower (higher int
	        			// value here) than the top of the stack, pop the operator from the
	        			// stack
	        			while (!dooku.isEmpty() && (char)dooku.peek() != '(' &&
	        					(precedence(c) >= precedence((char)dooku.peek())) ) {
	        				postfix = postfix + dooku.pop();
	        			} // end while
	        			// Push the remaining operator onto the stack
        				dooku.push(c);
	        			break;
	        		} // end switch
    		}
    		// 'c' was an operand and we want to push to the postfix expression
    		else {
    			// add operand to the postfix expression
    			postfix = postfix + c;	
    		}  // end if
    	} // end for loop
    	
    	// While the stack isn't empty we want to 
    	// pop the remaining operators to the postfix
    	while (!dooku.isEmpty()) {
    		postfix = postfix + dooku.pop();
    	} // end while
    	
    	// Send the postfix to the driver
        return postfix;
    }    
    
    
    /*
	 * Description:		This method accepts an infix expression
	 * 					and converts it to postfix
	 * Precondition: 	string param of infix expression
	 * Postcondition: 	return string of postfix expression
	 */
    public String postfixToInfix(String postfix)
    {
    	String infix = ""; 	// Postfix expression string
    	dooku.popAll(); 		// Make sure the stack is clear
    	
    	for (int i = 0; i < postfix.length()-1; i++) {
    		if (!isOperand(postfix.charAt(i)) && !isOperand(postfix.charAt(i+1)) ) {
    			dooku.push(')');
    			dooku.push(postfix.charAt(i));
    		} else if (!isOperand(postfix.charAt(i)) && isOperand(postfix.charAt(i+1)) ) {
    			dooku.push(postfix.charAt(i));
    		} else {
    			dooku.push(postfix.charAt(i));
    		} 
    	} dooku.push(postfix.charAt(postfix.length()-1));
    	dooku.display();
    	
    	while (!dooku.isEmpty()) {
    		if ( isOperand((char)dooku.peek()) ){
    			infix = (char)dooku.pop() + infix;
    			dooku.display();
    		} else if ( !isOperand((char)dooku.peek()) ) {
    			infix = '(' + (char)dooku.pop() + infix;
    			dooku.display();
    		}
    	}
    	
    	dooku.display();

    	
        return infix;
    }    
    
}
