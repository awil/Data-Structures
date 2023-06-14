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

import queue.QueueException;
import queue.RQueue; 

// Class Expressions handles the conversion from infix to postfix
public class Expressions {
	
	private RQueue jarjar; // Private RQueue for conversion
	
	/*
	 * Description:		Instantiate the queue
	 * Precondition: 	None
	 * Postcondition: 	jarjar queue is instantiated
	 */
	public Expressions() {
		jarjar = new RQueue();
	}
	
	/*
	 * Description:		This method confirms/denies the balanced
	 * 					status of the expression
	 * Precondition: 	String parameter (infix)
	 * Postcondition: 	True or false, based on balanced parentheses
	 */
	public boolean checkbalance(String expression) {
		boolean pBal = true; // boolean to store balance status	
		int i = 0;	// Iteration var
		
		while (pBal && i < expression.length()) {
			char c = expression.charAt(i); // using a char for simpler code
			++i; // iterate the count
			
			if (c == '(') {
				jarjar.enqueue(c);
			} else if (c == ')') {
				try {
					jarjar.dequeue();
				}
				catch (QueueException e) {
					pBal = false;
				}
			} // end if
		}
		
		if (pBal && jarjar.isEmpty()) {
			return true;
		} else {
			return false;
		}
		
	}
	
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
    
    public String infixToPostfix(String infix)
    {
    	String postfix = ""; // String to hold postfix
    	jarjar.dequeueAll(); // Clear the queue
    	int pre; // Integer var for precedence
    	
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
    						// Enqueue ( to the queue
	        				jarjar.enqueue(c);
    					break;
    				// Closing parenthesis
	        		case 1: 
        				// While the queue isn't empty and the front isn't '('
        				// Dequeue the element to the postfix expression
        				while (!jarjar.isEmpty()) {
        					if ((char)jarjar.peek() == '(') {
        						jarjar.dequeue();
        					} else {
            					postfix = postfix + jarjar.dequeue();
        					}
        				}  // end while
        				// Pop the remaining open parenthesis
	        			break;
	        		// Multiplication & Division
	        		case 2: 
	        		// Addition & Subtraction
	        		case 3:
	        			// While the queue isn't empty and the front isn't '('
	        			// we want to dequeue the operators into the postfix expression
	        			// if the precedence of the operator(charAt(i)) is lower (higher int
	        			// value here) than the front of the queue, dequeue the operator
	        			// from the queue
	        			while (!jarjar.isEmpty() && c == ')' &&
	        					(precedence(c) <= precedence((char)jarjar.peek())) ) {
	        				postfix = postfix + jarjar.dequeue();
	        			} // end while
	        			// Enqueue the remaining operator
	        			jarjar.enqueue(c);
	        			break;
	        		} // end switch
    		}
    		// 'c' was an operand and we want to dequeue to the postfix expression
    		else {
    			// Dequeue the operand to the postfix expression
    			postfix = postfix + c;	
    		}  // end if
    	} // end for loop
    	
    	// While the queue isn't empty we want to dequeue 
    	// the remaining operators to the postfix expression
    	while (!jarjar.isEmpty()) {
    		postfix = postfix + jarjar.dequeue();
    	} // end while

    	
    	// Send the converted postfix expression to the driver
        return postfix;
    }    
}
