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

public class BubbleSort {
	
	private int[] data; // Array to hold original array for sort
	
	/*
	 * Description:	Sorts items into ascending order from given array
	 * Precondition: The array is populated
	 * Postcondition: The array will be sorted and returned to the driver
	 */
	public int[] sort(int []data) {
		this.data = Arrays.copyOfRange(data, 0, data.length);
		bubblesort();
		return this.data;
	}

	/*
	 * Description:	Swapping method for the array
	 * Precondition: Two indices need swapping
	 * Postcondition: elements at data[i] and data[j] will be swapped
	 */
	private void swap(int i, int j) {
		int temp = this.data[i];
		this.data[i] = this.data[j];
		this.data[j] = temp;
	}
	
	/*
	 * Description:	Initiates the sorting, but in reverse from original algorithm
	 * Precondition: The array exists, method is called
	 * Postcondition: The array will loop through and call swap() for sorting
	 */
	private void bubblesort() {
		boolean sorted = false; // This will be false when swaps happen
		
		for (int pass = this.data.length; (pass >= 1) && !sorted; --pass) {
			// Start from the right side and go left
			sorted = true; // assume sorted
			for (int index = this.data.length-1; index > 0; --index) {
				// If the index (right value) is less, swap
				int nextIndex = index - 1;
				if (this.data[index] < this.data[nextIndex]) {
					// Exchange the items
					swap(index, nextIndex);
					sorted = false; // signal exchange
				} // End if
			} // End for
		} //End for
	}	

}
