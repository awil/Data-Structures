/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 6
 * Date started:	September 19, 2022
 * Date finished:	September 24, 2022
 * Description:		This project converts infix expressions to postfix using queues.
 */
package queue;

// This class handles creation of a queue
public class RQueue {
	
	private Node back; // Back node for end of queue

    /*
	 * Description:		This method instantiates the queue
	 * Precondition: 	None
	 * Postcondition: 	The back node will be null, until nodes are added.
	 * 					An empty queue is created.
	 */
	public RQueue() {
		back = null;
	}

    /*
	 * Description:		Check if the queue is empty
	 * Precondition: 	None
	 * Postcondition: 	If the back is equal to null, it's empty. 
	 * 					Back is returned true if so
	 */
	public boolean isEmpty() {
		return back == null; // If the back node is null, the queue is empty, return true
	}

    /*
	 * Description:		This adds an item to the queue
	 * Precondition: 	Object param of item
	 * Postcondition: 	The back of the queue will contain the new item
	 */
	public void enqueue(Object item) {
	    Node newNode = new Node(item); // New node for enqueue
	    // If the queue is empty, set newNode to the new item
	    if(isEmpty()) {
	      newNode.next = newNode;
	    } else {
	      newNode.next = back.next; // Not empty, set the items next node to the front node
	      back.next = newNode; // Change the back node to the updated newNode
	    } // End if
	    back = newNode; // Update the back node to reflect the newNode
	}
	
    /*
	 * Description:		This handles removing nodes from the queue
	 * Precondition: 	None
	 * Postcondition: 	The front node (back.next) is removed from the queue
	 */
	public Object dequeue() throws QueueException {
		// Make sure it's not empty
		if(!isEmpty()) {
			// Front node for handling removal (set to the front node)
			Node front = back.next;
		    if(front == back) {
		    	back = null; // There was only one node, empty the queue
		    } else {
		    	// Set the next node of the previous front, to the front (back.next)
		        back.next = front.next;
		    } // End if
		    return front.item; // Deliver the front node
		} else {
			// Queue was empty, throw exception
			throw new QueueException("QueueException on dequeue: queue empty");
		} 
	}

    /*
	 * Description:		This empties the queue
	 * Precondition: 	None	
	 * Postcondition: 	The back has been set to null, essentially emptying the queue
	 * 					since there will no longer be a front node (back.next)
	 */
	public void dequeueAll() {
		back = null;
	}

    /*
	 * Description:		This method shows the front of the queue
	 * Precondition: 	None
	 * Postcondition: 	The next item of the back node (front) is displayed
	 */
	public Object peek() throws QueueException {
		if (!isEmpty()) {
			return back.next.item;
		} else {
			throw new QueueException("Queue exception on peek queue empty");
	    }
	}
	  
    /*
	 * Description:		This method outputs the current queue to the console
	 * Precondition: 	None
	 * Postcondition: 	The queue will be displayed front to back in the console
	 */
	public void displayQueue() {
		System.out.print("f "); // Indicated the front
		// make sure the queue isn't empty
		if(back != null) {
			// Use a temp node for iterating nodes
			Node temp = back.next;
			// while the temp isn't the back node, keep showing the nodes
			while(temp != back) {
				System.out.print(temp.item + " ");
				// Set the temp to the next node
				temp = temp.next;
			} // End while
			System.out.print(temp.item + " ");
		} // End if
		// Indicate the back
		System.out.println("b");
	}

}