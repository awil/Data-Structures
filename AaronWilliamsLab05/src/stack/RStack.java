/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 5
 * Date started:	September 13, 2022
 * Date finished:	September 18, 2022
 * Description:		This project converts infix expressions to postfix.
 */
package stack;

// Class for handling stacks
public class RStack {
	
	private Node top; // Create a node for the head

	/*
	 * Description:		Constructor method to instantiate the stack
	 * Precondition: 	None
	 * Postcondition: 	Empty stack is instantiated
	 */
	public RStack() {
		top = null;
	}
	
	/*
	 * Description:		This method tests to see if the stack is
	 * 					empty. 
	 * Precondition: 	None
	 * Postcondition: 	If it's empty, returns true. If not,
	 * 					returns false.
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/*
	 * Description:		This method adds a node to the top of the
	 * 					stack. 
	 * Precondition: 	None
	 * Postcondition: 	New node added to top
	 */
	public void push(Object newItem) {
		top = new Node(newItem, top);
	}

	/*
	 * Description:		This method pops a node off the stack. If
	 * 					the stack is empty, throws exception.
	 * Precondition: 	None
	 * Postcondition: 	Stack is returned, without the previous
	 * 					top node.
	 */
	public Object pop() throws StackException {
		if(!isEmpty()) {
			Node temp = top;
			top = top.next;
			return temp.item;
		} else {
			throw new StackException("StackException on pop: stack empty");
		}
	}

	/*
	 * Description:		This method empties the stack by removing
	 * 					the top node.
	 * Precondition: 	None
	 * Postcondition: 	Stack is emptied.
	 */
	public void popAll() {
		top = null; // Set top to null
	}

	/*
	 * Description:		This method "peeks" at the top node of the
	 * 					stack, by returning the top node. If not, throw exception
	 * Precondition: 	Top node
	 * Postcondition: 	Returns the top node
	 */
	public Object peek() throws StackException {
		if(!isEmpty()) {
			return top.item;
		} else {
			throw new StackException("StackException on peek: stack empty");
		}
	}
	
	/*
	 * Description:	This method displays the nodes of the stack
	 * Precondition: Stack isn't empty
	 * Postcondition: The stack is displayed from top to base
	 */
	public void display() {
		Node curr = top;
		
		System.out.print("Top "); 
		while(curr != null) {
			System.out.print(curr.item.toString() + " ");
			curr = curr.next;
		}
		System.out.println("Base ");
	}
	
}
