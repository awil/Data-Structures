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

public class DualPivotQuickSort {

	private int[] data;	// Hold original array
	
	/*
	 * Description:	Initiates the sorting/sets up everything
	 * Precondition: Array is filled
	 * Postcondition: The final array will be sorted in ascending order
	 */
	public int[] sort(int[] data) {
		this.data = Arrays.copyOfRange(data, 0, data.length);
		quicksort(0, data.length-1);
		return this.data;
	}
	/*
	 * Description:	Sorts the array left to right using recursion
	 * Precondition: Array is filled in sort()
	 * Postcondition: The resulting array will be sorted in ascending order
	 * 				  using three partitions.
	 */
	private void quicksort(int left, int right) {
		if (left < right) {
			// Choose a pivot, sort the array
			int[] pivots = partition(left, right);
			
			// Sort the first partition
			quicksort(left, pivots[0]-1);
			// Sort the second partition
			quicksort(pivots[0] + 1, pivots[1]-1);
			// Sort the third partition
			quicksort(pivots[1] + 1, right);
		} // End if
		// If left is >= right, nothing to be done
	}	

	/*
	 * Description:	This swaps to elements in the array
	 * Precondition: i, j are provided
	 * Postcondition: this.data[i] will be swapped with this.data[j]
	 */
	private void swap(int i, int j) {
		int temp;
		temp = this.data[i];
		this.data[i] = this.data[j];
		this.data[j] = temp;
	}
	
	/*
	 * Description:	This method returns the pivot for sorting
	 * Precondition: Left, Right are sent
	 * Postcondition: Returns the index  
	 */
	private int[] partition(int left, int right) {
	    // Swap data[left] with data[right] if greater
	    if (this.data[left] > this.data[right]) {
	    	swap(left, right);
	    }
    	int j = left + 1;
    	int k = left + 1;
    	int g = right - 1;
    	int p = this.data[left];
    	int q = this.data[right];
	    	
    	while (k <= g) {
    		if (this.data[k] < p) {
    			swap(k, j);
    			++j;
    		} else if (this.data[k] >= q) {
    			while ((this.data[g] > q) && (k < g)) {
    				--g;
    			} // End while
    			swap(k, g);
    			--g;
    			if (this.data[k] < p) {
    				swap(k, j);
    				++j;
    			} // End if
    		} // End if
    		++k;
    	} // End while
    	
    	--j;
    	++g;
    	swap(left, j);
    	swap(right, g);
    	int[] pivot = {j, g}; // Set the pivots
	    // Return the pivot array

	    return pivot;
	}
}
