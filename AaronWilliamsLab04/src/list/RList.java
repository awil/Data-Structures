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
package list;

public class RList {
	
	private Node head;	
	private int k; 		

	public RList() {
		k = 0; 
		head = null; 
	}

	public boolean isEmpty() {
		return (k == 0);
	}

	public int size() {
		return k;
	}

	public void add(int index, Object o) throws ListIndexOutOfBoundsException {
		if(index >= 0 && index < k+1) {
			if(index == 0) {
				Node newNode = new Node(o, head);
				head = newNode;
			} else {
				Node prev = find(index-1);
				Node newNode = new Node(o, prev.next);
				prev.next = newNode;
			}
			k++;
		} else {
			throw new ListIndexOutOfBoundsException("List index out of bounds on add");
		} // End if
	}
	
	private Node find(int index) {
		
		Node curr = head;
		for(int skip = 0; skip < index; skip++) {
			curr = curr.next;
		} // End for
		
		return curr;
	}
	
	public Object get(int index) throws ListIndexOutOfBoundsException {
		if(index >= 0 && index < k) {
			Node curr = find(index);
			Object item = curr.item;
			return item;
		} else {
			throw new ListIndexOutOfBoundsException("List index out of bounds on get");
		} // End if
	}	

	public void remove(int index) throws ListIndexOutOfBoundsException {
		if(index >= 0 && index < k) {
			if(index == 0) {
				head = head.next;
			} else {
				Node prev = find(index-1);
				Node curr = prev.next;
				prev.next = curr.next;
			}
			k--;
		} else {
			throw new ListIndexOutOfBoundsException("List index out of bounds on remove");
		} // End if
	}
	
	public void clear() {
		head = null;
		k = 0;
	}

	public void display() {
		Node curr = head;
		while(curr != null) {
			System.out.printf("%-18s  %-22s  %s\n", curr, curr.item, curr.next);
			curr = curr.next;
		} // End while
	}

	public void testComparison(Object o) {
		Node curr = head;
		if(curr.item.equals(o)) {
			System.out.println("Matches");
		} else {
			System.out.println("Does not match");
		} // End if
	}
	
	/*
	 * Description:		This method adds the Person object to the end of
	 *					the list. Use prev and curr pointers to walk to 
	 *					the end of the list and add it.
	 * Precondition:	Object param passed
	 * Postcondition:	New object added to the end
	 */
	public void add(Object o) {
		Node curr; // Node for traversing
		
		// If the head doesn't exist, add node here
		if (head == null) {
			head = new Node(o, null);
		} else {
			// Look for the last ndoe
			for (curr = head; curr != null; curr = curr.next) {
				// If curr.next is null, we've found the last node
				// add the new node here
				if (curr.next == null) {
					curr.next = new Node(o, null);
					break;
				} // End if
			} // End for
		} // End if
		k++;
	}
	
	/*
	 * Description:		This method adds the Person object as the first
	 * 					object in the list.
	 * Precondition:	Object param
	 * Postcondition:	First node is switched with new object
	 */
	public void addFirst(Object o) {
		// Create a new node with object param
		Node newNode = new Node(o, head);
		head = newNode; // Replace the first object
		k++; // Increment the list total
	}
	
	/*
	 * Description:		This method walks the list using prev and curr pointers to
	 *					find the index of the first occurrence of the Person object
	 *					passed into the method. 
	 * Precondition:	Object param
	 * Postcondition:	Return the index of that object
	 */
	public int indexOf(Object o) {
		int index = 0; // index param for incrementing
		Node curr; // curr node for traversing
		
		// Check to see if object exists
		if (head != null || o == null) {
			return index;
		} else {
			// Loop through the list to find the index of the
			// passed object
			for (curr = head; curr != null; curr = curr.next) {
				// Match has been found, return the index
				if (curr.item.equals(o)) {
					return index;
				} // End if
				// increment index and loop more
				index++;
			} // End for
		} // End if

		return -1;
		
	}

	/*
	 * Description:		This method walks the list using prev and curr pointers to
						find the index of the last occurrence of the Person object
						passed into the method. 
	 * Precondition:	Object param
	 * Postcondition:	The last of us index is found
	 */
	public int lastIndexOf(Object o) {
		Node prev = null; // prev pointer for traversing
		Node curr = head; // curr pointer for traversing
		Node nxt = head; // nxt pointer for traversing
		int index = 0; // Index for counting
		
		// Cycle through the list and reverse it
		// so we can find the last occurrence
		while (curr != null) {
			nxt = nxt.next; // hold the next for the head
			curr.next = prev; // set the curr next to the previous node
			prev = curr; // set the previous node to the current
			curr = nxt; // then set the current to the next after that
		} // end while
		head = prev; // Set the new head
		
		// Test to see if the head exists & object isn't null
		if (head == null || o == null) {
			return 0;
		} else if (head.item.equals(o)){
			// Head matches the object
			head = head.next;
			// Return the index of it
			return index - 1;
		} else {
			curr = head; // reset the curr for traversal
			// Cycle through the reversed list  
			while (curr != null) {
				// If match is found, stop and reverse the list
				if (curr.item.equals(o)) {
					prev = null; 
					curr = head;
					nxt = head;
					// Reversing the list to restore it to original state
					while (curr != null) {
						nxt = nxt.next;
						curr.next = prev;
						prev = curr;
						curr = nxt;
					} // end while 
					head = prev;
					// return the index here (here you have to subtract the 
					// counted index since we reversed the list, then subtract
					// one from the total for the actual index
					return k - index - 1;
				} // End if
				curr = curr.next;
				// increment the index
				index++;
			} // end while 
		}

		return -1;
	}
	
	/*
	 * Description:		This method walks the list using prev and curr pointers to
						find and remove the first occurrence of the Person object
						passed into the method. It returns true if it removes a Person,
						false otherwise. 
	 * Precondition:	Object param
	 * Postcondition:	 The selected object is removed
	 */
	public boolean remove(Object o) {
		Node prev = head; // prev pointer for traversing
		Node curr = head.next; // curr pointer for traversing
		
		// if head doesn't exist, return false
		if (head == null || o == null) {
			return false;
		} else if (head.item.equals(o)){
			// If the head matches, cut it off
			head = head.next;
			// Decrement the list and return true
			k--;
			return true;
		} else {
			// Traverse the list using pointer
			while (curr != null) {
				// If a match has been found, replace it
				if (curr.item.equals(o)) {
					prev.next = curr.next;
					// Decrement the list and return true
					k--;
					return true;
				} // End if
				prev = curr;
				curr = curr.next;
			} // End while
		} // End if

		return false;
	
	}
	
	/*
	 * Description:		This method walks the list using prev and curr points to 
						remove the last item. It returns true unless the list is empty.
	 * Precondition:	There's an end node
	 * Postcondition:	The last node is removed
	 */
	public boolean removeLast() {
		Node prev = head; // prev pointer for traversing
		Node curr = head.next; // curr pointer for traversing
		
		// if head doesn't exist, return false
		if (head == null) {
			return false;
		} else if (head.next == null){
			// Since head is the last, remove
			// and set to null
			head = null;
			return true;
		} else {
			// Cycle through the list until the last node
			while (curr != null) {
				// If the last node has been found, let's
				// remove it
				if (curr.next == null) {
					prev.next = null;
					// Decrement the list and return true
					k--;
					return true;
				} // End if
				prev = curr;
				curr = curr.next;
			} // End while 
		} // End if

		return false;
	}
	
	/*
	 * Description:		This method walks the list using prev and curr pointers to
						find and remove the last occurrence of the Person object
						passed into the method. 
	 * Precondition:	Object param
	 * Postcondition:	The last found matching object is removed
	 */
	public boolean removeLast(Object o) {
		Node prev = null; // prev pointer for traversal
		Node curr = head; // curr pointer for traversal
		Node nxt = head; // temporary pointer for manipulation
		
		// Cycle through the list and reverse it
		// so we can find the last occurrence
		while (curr != null) {
			nxt = nxt.next; // hold the next for the head
			curr.next = prev; // set the curr next to the previous node
			prev = curr; // set the previous node to the current
			curr = nxt; // then set the current to the next after that
		} // end while
		head = prev; // crown the new king
		
		if (head == null || o == null) {
			return false;
		} else if (head.item.equals(o)){
			// Head is equal to the object, so
			// Set the head to the next node
			head = head.next;
			// Decrement the count
			k--;
			return true;
		} else {
			curr = head; 
			while (prev != null) {
				if (curr.item.equals(o)) {
					// switch out the next pointer of the previous
					// to get rid of the node
					prev.next = curr.next;
					
					// reset the params for reversing the list again
					prev = null; 
					curr = head;
					nxt = head;
					
					// Cycle through the list to reverse it
					// and restore order to the galaxy
					while (curr != null) {
						nxt = nxt.next;
						curr.next = prev;
						prev = curr;
						curr = nxt;
					} // End while 
					head = prev;
					// Decrement the list since we removed a node
					k--;
					// Return to true for success
					return true;
				} // End if
				prev = curr; // Move to the next to continue the while loop
				curr = curr.next;
			} // End while 
		} // End if

		return false;
	}
	
	/*
	 * Description:		This method walks the list using prev and curr pointers to
						find and remove all occurrences of objects matching the
						Person object passed into the method. 
	 * Precondition:	object param
	 * Postcondition:	All objects matching were removed
	 */
	public int removeAll(Object o) {
		Node prev = head;
		Node curr = head.next;
		
		// Test to see if the head exists & object isn't null
		if (head == null || o == null) {
			return 0;
		} else if (head.item.equals(o)){
			// Replace the head if it is equal to the object
			head = head.next;
			k--; // Decrement the list number before returning
			return 0;
		} else {
			int count = 0; // Count instances
			
			// Traverse the list using curr ptr
			while (curr != null) {
				// If curr equals our object, remove it
				if (curr.item.equals(o)) {
					prev.next = curr.next;
					count++; // increment the count
					k--; //decrement the list since we removed one
				} // End if
				prev = curr;
				curr = curr.next;
			} // End while
			return count;
		} // End if
		
	}
	
	/*
	 * Description:		This method walks the list to the indexed position and
						replaces the node with a new one that contains the
						Person passed into the method. 
	 * Precondition:	index param, object param
	 * Postcondition:	Nodes are replaced for selected index 
	 */
	public void set(int index, Object o) {
		// Check to see if the index is valid
		if(index >= 0 && index < k+1) {
			// Index is 0? set the object 
			if(index == 0) {
				Node tmp = new Node(o, head); // New node with replacement
				head = tmp; // Set head to the new node
			} else {
				Node prev = head; // pointer for prev
				Node curr = head; // pointer for curr
				// Cycle through the nodes to find the correct
				// index 
				for(int i = 0; i < index; i++) {
					prev = curr;
					curr = curr.next;
				} // End loop
				// This replaces the selected node with the new one
				Node tmp = new Node(o, curr.next);
				prev.next = tmp;
			} // End if
		} // End if
	}
	
	/*
	 * Description:		This method walks the list and replaces each node
	 * 					with a person matching the find Person passed into 
	 * 					the method with the replacement Person
	 * Precondition:	find param and replacement param
	 * Postcondition:	All matching objects are replaced
	 */
	public void setAll(Object find, Object replacement) {
		Node prev = head; // prev pointer to head
		Node curr = head.next; // curr pointer to next node
		Node tmp = new Node(replacement, curr); // temp node for the replacement
		
		// Does the head exist, if not set to tmp
		// If head is equal to the find node, set to the tmp replacement
		if (head == null || find == null) {
			head = tmp;
		} else if (head.item.equals(find)){
			head = tmp;
		} else {
			// Traverse the list until we find a match
			while (curr != null) {
				// When match is found set to replacement
				if (curr.item.equals(find)) {
					tmp = new Node(replacement, curr.next);
					prev.next = tmp;
				} // End if
				prev = curr;
				curr = curr.next;
			} // End while
		} // End if
		
	}
	
	/*
	 * Description:	This method creates an array of Objects 
	 * 				and then walks the list adding each Person 
	 * 				object to the array
	 * Precondition:	
	 * Postcondition:	 
	 */
	public Object[] toArray() {
		// Object array list
		Object[] array = new Object[k];
		Node curr = head; // Head pointer
		
		// Step through the nodes and add each to object array
		if (curr != null) {
			for (int i = 0; i < k-1; i++) {
				array[i] = curr;
				curr = curr.next;
			} // End for loop
		} // End if 
		
		// Return the array
		return array;
	}
	
}
