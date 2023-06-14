/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 7
 * Date started:	September 28, 2022
 * Date finished:	October 1, 2022
 * Description:		This program demonstrates a selection of sorting algorithms
 *					from the text but in reverse.
 */
package sorters;

import java.util.Arrays;

public class ShellSort {

	private int[] data; // Array to hold original array for sort
	
	/*
	 * Description:	Sets up the sorting
	 * Precondition: The array is populated
	 * Postcondition: The array will be sorted and returned to the driver
	 */
	public int[] sort(int[] data) {
		this.data = Arrays.copyOfRange(data, 0, data.length);
		shellsort();
		return this.data;
	}	
	
	/*
	 * Description:	Sorts the array into ascending order, backwards
	 * Precondition: this.data is filled with array items
	 * Postcondition: this.data will be sorted in ascending order
	 */
	public void shellsort() {
		int loc; // index location of item being sorted
		int nextItem; // nextItem is the next unsorted item
		// divide into subsection/sort from there
		for (int h = this.data.length/2; h > 0; h = h/2) {
			// process sub section in reverse
			for (int unsorted = this.data.length-1; unsorted > 0; --unsorted) {
				nextItem = this.data[unsorted];
				loc = unsorted;
				// Sort the items in ascending order
				while ((loc >= h) &&
						(this.data[loc-h] > nextItem)) {
					this.data[loc] = this.data[loc-h];
					loc = loc - h;
				} // End while
			this.data[loc] = nextItem;
			} // End for unsorted
		} // End for h
	}
	
}
