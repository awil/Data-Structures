/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 7
 * Date started:	September 28, 2022
 * Date finished:	October 2, 2022
 * Description:		This program demonstrates a selection of sorting algorithms
					from the text but in reverse.
 */
package sorters;

import java.util.Arrays;

public class BubbleSort {
	
	private int[] data; // Array to hold original array for sort
	
	/*
	 * Description:	Sorts items into descending order from given array
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
	 * Description:	Initiates the sorting
	 * Precondition: The array exists, method is called
	 * Postcondition: The array will loop through and call swap() for sorting
	 */
	private void bubblesort() {
		boolean sorted = false; // This will be false when swaps happen
		
		for (int pass = 1; (pass < this.data.length) && !sorted; ++pass) {
			// Invariant: this.data[n+1-pass..n-1] is sorted
			// 				and > this.data[0..n-pass]
			sorted = true; // assume sorted
			for (int index = 0; index < this.data.length-pass; ++index) {
				// Invariant this.data[0..index-1] <= this.data[index]
				int nextIndex = index + 1;
				if (this.data[index] < this.data[nextIndex]) {
					// Exchange the items
					swap(index, nextIndex);
					sorted = false; // signal exchange
				} // End if
			} // End for
			// Assertion this.data[0..n-pass-1] < this.data[n-pass]
		} //End for
	}	

}
