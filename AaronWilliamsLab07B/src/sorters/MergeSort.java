/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 7
 * Date started:	September 28, 2022
 * Date finished:	October 2, 2022
 * Description:		This program demonstrates a selection of sorting algorithms from the text but in reverse.
 */
package sorters;

import java.util.Arrays;

public class MergeSort {

	private int[] temp; // Temp array for merge
	private int[] data; // Holds the original array
	
	/*
	 * Description:	Initiates the sorting/sets up everything
	 * Precondition: Array is filled
	 * Postcondition: The resulting array will be sorted descending  
	 */
	public int[] sort(int[] data) {
		this.data = Arrays.copyOfRange(data, 0, data.length);
		this.temp = new int[data.length];
		mergesort(0, data.length-1);
		return this.data;
	}
	
	/*
	 * Description:	This method halves this.data for sorting recursively
	 * Precondition: this.data is filled in sort()
	 * Postcondition: The array is organized into descending order
	 */
	private void mergesort(int first, int last) {
		if (first < last) {
			int mid = (first + last)/2; // Find the midpoint

			// Sort left half the array[first...mid]
			mergesort(first, mid);
			// Sort right half the array[mid+1...last]
			mergesort(mid+1, last);
			// Merge the two halves
			merge(first, mid, last);
		} // End if
	}  
	
	/*
	 * Description:	This method traverses this.data, copying items into this.temp
	 * 				2 by 2 until all the elements have been sorted properly in descending
	 * 				order.
	 * Precondition: The halves are sorted in decreasing order
	 * Postcondition: this.data is sorted in descending order
	 */
	private void merge(int first, int mid, int last) {
		// Initialize the local indexes to indicate the sub-arrays
		int first1 = first;		// Beginning of first sub-array
		int last1 = mid; 		// End of first sub-array
		int first2 = mid + 1;	// Beginning of second sub-array
		int last2 = last;		// End of second sub-array
		// while both sub-arrays are not empty, copy the
		// smaller item into the this.temp array.
		int index = first1;		// Next available location in this.temp array
		
		while ((first1 <= last1) && (first2 <= last2)) {
			// Invariant: this.temp[first1..index-1] is in order
			if (this.data[first1] > this.data[first2]) {
				this.temp[index] = this.data[first1];
				first1++;
			} else {
				this.temp[index] = this.data[first2];
				first2++;
			} // End if
			index++;
		} // End while
		
		// Finish the nonempty sub-array
		
		// Finish the first sub-array, if needed.
		while (first1 <= last1) {
			// Invariant: this.temp[first1..index-1] is in order
			this.temp[index] = this.data[first1];

			first1++;
			index++;
		} // End while
		
		// Finish the second sub-array, if we need to
		while (first2 <= last2) {
			// Invariant: this.temp[first1..index-1] is in order
			this.temp[index] = this.data[first2];

			first2++;
			index++;
		} // End while
		
		// Copy results back into original array
		for (index = first; index <= last; ++index) {
			this.data[index] = this.temp[index];
		} // End for
	} // End merge
		
}


























