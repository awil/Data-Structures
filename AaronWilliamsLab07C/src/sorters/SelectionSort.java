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

public class SelectionSort {

	private int[] data; // Array to hold original array for sort
	
	/*
	 * Description:	Sets up the sorting
	 * Precondition: The array is populated
	 * Postcondition: The array will be sorted and returned to the driver
	 */
	public int[] sort(int []data) {
		this.data = Arrays.copyOfRange(data, 0, data.length);
		selectionsort();
		return this.data;
	}
	
	/*
	 * Description:	Sorts the array into ascending order
	 * Precondition: this.data is filled with array items
	 * Postcondition: this.data will be sorted in ascending order
	 */
	public void selectionsort() {
		// Traverse the array, finding the largest index and sort from there
		for (int last = 0; last < data.length-1; last++) {
			int largest = indexOfLargest(last-1);
			
			int temp = this.data[largest+1];
			this.data[largest+1] = this.data[last];
			this.data[last] = temp;
		} // End for
	}
	
	/*
	 * Description:	Returns the index of the largest item 
	 * Precondition: this.data has enough items to sort (>= 1)
	 * Postcondition: Returns largest item's index
	 */
	public int indexOfLargest(int size) {
		int indexSoFar = size; // Default index
		
		// Invariant: item at index this.data[indexSoFar] is >= this.data[0..currIndex-1]
		for (int currIndex = size; currIndex > 1; --currIndex) {
			if (this.data[currIndex] > this.data[indexSoFar] ) {
				indexSoFar = currIndex;
			} // End if
		} // End for
		
		// Return to sender
		return indexSoFar;
	}
		
}