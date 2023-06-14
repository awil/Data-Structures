/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 9
 * Date started:	October 27, 2022
 * Date finished:	October 29, 2022
 * Description:		This program works with priority queues, min/max heaps.
 */
package heaps;

import java.util.ArrayList;

import items.Node;

// adapted from Data Structures and Algorithms in Java, 2nd ed, Robert Lafore

public class MaxHeap {
	
	private ArrayList<Node> heap;
	private int size; 		// number of nodes in heap

	/*
	 * Description:	MinHeap constructor method
	 * Precondition: None
	 * Postcondition: MinHeap is instantiated
	 */
	public MaxHeap() {
	    this.size = 0;
	    this.heap = new ArrayList<Node>();
	}

	/*
	 * Description:	Returns heap's empty status
	 * Precondition: None
	 * Postcondition: True if empty, false if not
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/*
	 * Description:	Inserts an item into the heap
	 * Precondition: Key param passed
	 * Postcondition: Boolean value true if successful, false if not
	 */
    public boolean insert(int key) {
    	boolean success = false;
    	
        if(size <= heap.size()) {
	        Node newNode = new Node(key);
	        heap.add(newNode);
	        trickleUp(size);
	        size++;
	        success = true;
        }
        return success;
    } 

	/*
	 * Description:	This method sends the index up through the heap to the
	 * 				right position. Largest value to the top
	 * Precondition: Index param passed in
	 * Postcondition: Root is the lowest item
	 */
    public void trickleUp(int index) {
    	int parent = (index-1)/2;
    	Node bottom = heap.get(index);
	    
    	while(index > 0 && heap.get(parent).getKey().compareTo(bottom.getKey()) <= 0) {
    		heap.set(index, heap.get(parent)); // move it up
	        index = parent;
	        parent = (parent-1)/2;
	    }
    	heap.set(index, bottom);
	}

	/*
	 * Description:	This method removes the top value from the heap
	 * Precondition: method call
	 * Postcondition: The root value is removed, new root returned
	 */
    public Node remove() {
    	// note: assumes it is not empty
	    Node root = null;
	    
	    // Test for the heap being empty
	    if(!heap.isEmpty()) {  
	    	root = heap.get(0);
		    size--;
		    // Set the root to the last item
		    heap.set(0, heap.get(size));
		    heap.remove(size);
		    // Adjust the heap
		    if(!heap.isEmpty()) trickleDown(0);
		    return root;
	    } else {
	    	return root;
	    }
	}
    
	/*
	 * Description:	This method finds the smaller children and moves them down
	 * Precondition: Index param passed in
	 * Postcondition: The item at the index is "sifted" down to the bottom of the heap
	 */
    public void trickleDown(int index) {
    	int smallerChild;
	    Node top = heap.get(index);
	    
	    // while node has at least one child
	    while(index < (size/2)) {
	    	int leftChild = 2*index+1;
	        int rightChild = leftChild+1;
	        // find smaller child
	        if(rightChild < size && heap.get(leftChild).getKey().compareTo(heap.get(rightChild).getKey()) <= 0) {
	        	// rightChild exists
	            smallerChild = rightChild;
	        } else {
	        	//top >= smallerChild
	        	smallerChild = leftChild;
	        }
	        if(top.getKey() >= heap.get(smallerChild).getKey()) {
	        	break;
	        }
	        // move child up
	        heap.set(index, heap.get(smallerChild));
	        index = smallerChild; // go down
	    }
	    heap.set(index, top); // root to index
	}

	/*
	 * Description:	This method changes the value of an item
	 * Precondition: Index param passed in, new value param passed 
	 * Postcondition: The item will be changed, then the heap will be adjusted
	 */
    public boolean change(int index, int newValue) {
    	boolean success = false;
    	if(index >= 0 && index <= size) {
    		int oldValue = heap.get(index).getKey();// remember old
    		heap.get(index).setKey(newValue); 		// change to new
    		if(oldValue > newValue) { 			// if raised,
    			trickleUp(index); 				// trickle it up
    		} else { 							// if lowered
    			trickleDown(index); 			// trickle it down
    		}
    		success = true;    		
    	}
    	
    	return success;
    }

	/*
	 * Description:	This method displays the heap in formatted output
	 * Precondition: None
	 * Postcondition: The heap is output to the console
	 */
    public void displayHeap() {
    	System.out.print("Heap: "); // array format
	    for(int i = 0; i < size; i++) {
	    	if(heap.get(i) != null) {
	    		System.out.print(heap.get(i).getKey() + " ");
	    	} else {
	            System.out.print("-- ");
	    	}
	    }
	    System.out.println();
		// heap display formatting
	    int nBlanks = 32;
	    int itemsPerRow = 1;
	    int column = 0;
	    int j = 0; // current item
	    System.out.println("--------------------------------------------------------------");
	    while(size > 0) { 		// for each heap item
	    	if(column == 0) { 	// first item in row?
	    		for (int k = 0; k < nBlanks; k++) { // preceding blanks
	    			System.out.print(" ");
	    		}
	        }
	        // display item
	    	System.out.print(heap.get(j).getKey());
	        j++;
	        if(j == size) {// done
	        	break;
	        }
	        column++;
	        if(column == itemsPerRow) {	// end of row?
	        	nBlanks /= 2; 			// half the blanks
	            itemsPerRow *= 2; 		// twice the items
	            column = 0; 			// start over on
	            System.out.println(); 	// new row
	        } else { 					// next item on row
	        	for(int k = 0; k < nBlanks*2-2; k++) {
	        		System.out.print(' '); // interim blanks
	        	}
	        }
	    }
	    System.out.println();
	    System.out.println("--------------------------------------------------------------");
    }
}