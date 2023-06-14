/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 7
 * Date started:	September 28, 2022
 * Date finished:	October 1, 2022
 * Description:		This program demonstrates a selection of sorting algorithms from the text.
 */
package sorters;

import java.util.Arrays;

public class InsertionSort {
	
	private int[] data; // Hold original array
	
	/*
	 * Description:	Initiates the sorting/sets up everything
	 * Precondition: Array is filled
	 * Postcondition: The resulting array will be sorted ascending  
	 */
	public int[] sort(int []data) {
		this.data = Arrays.copyOfRange(data, 0, data.length);
		// Call sorting method
		insertionsort();
		// Return to sender 
		return this.data;
	}
	
	/*
	 * Description:	This method does the sorting
	 * Precondition: The array is sent from sort()
	 * Postcondition: The array is organized into ascending order
	 */
	public void insertionsort() {
		// unsorted is the first index of the unsorted part
		for (int unsorted = 1; unsorted < this.data.length; ++unsorted) {
			int nextItem = this.data[unsorted]; // nextItem is the next item in the unsorted part to be placed
			int loc = unsorted; // loc is the index where the insert will be for the sorted part
			// Here the method finds the right position, and determines whether to shift,
			// if so it makes room and completes the shift

			while ((loc > 0) &&
					(this.data[loc-1] > nextItem)) {
				// We need to shift the item to the right to continue the sort
				this.data[loc] = this.data[loc-1];
				loc--;
			} // End while
			// Assertion: this.data[loc] is where nextItem should be placed
			// Insert nextItem there
			this.data[loc] = nextItem;
		} // End for
	}

}
