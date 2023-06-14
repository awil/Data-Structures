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

public class QuickSort {

	private int[] data; // Hold original array
	
	/*
	 * Description:	Initiates the sorting/sets up everything
	 * Precondition: Array is filled
	 * Postcondition: The resulting array will be sorted into ascending order
	 */
	public int[] sort(int[] data) {
		this.data = Arrays.copyOfRange(data, 0, data.length);
		quicksort(0, data.length-1);
		// Return to sender
		return this.data;
	}
	
	/*
	 * Description:	Sorts the array left to right using recursion
	 * Precondition: Array is filled in sort()
	 * Postcondition: The resulting array will be sorted in ascending order
	 */
	private void quicksort(int left, int right) {
		int pivot; // Pivot point

		if (left < right) {
			// Choose a pivot, sort the array
			pivot = partition(left, right);
			// Sort the left half
			quicksort(left, pivot-1);
			// Sort the right half
			quicksort(pivot+1, right);
		} // End if
		// If left is >= right, nothing to be done
	}	

	/*
	 * Description:	This method returns the pivot for sorting
	 * Precondition: Left, Right are sent
	 * Postcondition: Returns the index  
	 */
	private int partition(int left, int right) {
		int temp; // Used for swapping
		int pivot = this.data[left]; // Set the pivot
		int lastS1 = left; // Index of last S1 item
		
		// Relocate elements one at a time until unknown section is empty
		// firstUnknown is the index of the first element in the unknown section
		for (int firstUnknown = left + 1; firstUnknown <= right; ++firstUnknown) {
			// this.data[first+1..lastS1] will be < pivot
			// this.data[lastS1+1..firstUnknown-1] will be >= pivot
			if (this.data[firstUnknown] < pivot) { 
				// move item to S1
				++lastS1;
				temp = this.data[firstUnknown];
				this.data[firstUnknown] = this.data[lastS1];
				this.data[lastS1] = temp;
			} // End if
			// Else -> item from unknown belongs in S2
		} // End for
		
		// Place pivot in the right spot and return location
		temp = this.data[left];
		this.data[left] = this.data[lastS1];
		this.data[lastS1] = temp;
		return lastS1;
	}

}
