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

public class MergeSort {

	private int[] temp; // Temp array for merge
	private int[] data; // Holds the original array
	
	/*
	 * Description:	Initiates the sorting/sets up everything
	 * Precondition: Array is filled
	 * Postcondition: The resulting array will be sorted ascending  
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
	 * Postcondition: The array is organized into ascending order
	 */
	private void mergesort(int first, int last) {
		if (last - first < 2) {
			return;
		}
		
		if (first < last) {
			int mid1;
			int mid2;
			
			if (data.length % 2 == 0) {
				int tmp = data.length / 3;
				mid1 = tmp;
				mid2 = tmp * 2;
			} else {
				int tmp = data.length / 3;
				mid1 = tmp;
				mid2 = (tmp * 2) + 1;
			}

			// Sort first third the array[first...mid1]
//			mergesort(first, mid1);
//			// Sort second third the array[mid1+1...mid2-1]
//			mergesort(mid1, mid2-1);
//			// Sort last third the array[mid2...last]
//			mergesort(mid2, last);
			// Merge the two halves
			merge(first, mid1, mid2, last);
		} // End if
	}  
	
	/*
	 * Description:	This method traverses this.data, copying items into this.temp
	 * 				2 by 2 until all the elements have been sorted properly in ascending
	 * 				order.
	 * Precondition: The halves are sorted in increasing order
	 * Postcondition: this.data is sorted in ascending order
	 */
	private void merge(int first, int mid1, int mid2, int last) {
		// Initialize the local indexes to indicate the sub-arrays
		int first1 = first;		// Beginning of first sub-array
		int last1 = mid1-1; 		// End of first sub-array
		int first2 = mid1;	// Beginning of second sub-array
		int last2 = mid2 - 1;		// End of second sub-array
		int first3 = mid2;
		int last3 = last;
		// while both sub-arrays are not empty, copy the
		// smaller item into the this.temp array.
		int index = first1;		// Next available location in this.temp array
		
		
		while ((first1 <= last1) && (first2 <= last2) && (first3 <= last3)) {
			// Invariant: this.temp[first1..index-1] is in order
			if (this.data[first1] < this.data[first2]) {
				this.temp[index] = this.data[first1];
				first1++;
			} else if (this.data[first2] < this.data[first3]){
				this.temp[index] = this.data[first2];
				first2++;
			} else {
				this.temp[index] = this.data[first3];
				first2++;
			}
			
			// End if
			index++;
		} // End while
		
		// Finish the nonempty sub-array
		
		// Finish the first subarray, if needed.
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
		
		// Finish the third sub-array, if we need to
		while (first3 <= last3) {
			// Invariant: this.temp[first1..index-1] is in order
			this.temp[index] = this.data[first3];

			first3++;
			index++;
		} // End while
		
		// Copy results back into original array
		for (index = first; index <= last; ++index) {
			this.data[index] = this.temp[index];
		} // End for
	} // End merge
		
}


























