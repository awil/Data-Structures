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

	private int[] data;
	
	public int[] sort(int[] data) {
		this.data = Arrays.copyOfRange(data, 0, data.length);
		quicksort(0, data.length-1);
		return this.data;
	}
	
	private void quicksort(int left, int right) {

	}	

	private void swap(int i, int j) {

	}
	
	private int[] partition(int left, int right) {
	    int[] pivot = null;
	    
	    return pivot;
	}
}
