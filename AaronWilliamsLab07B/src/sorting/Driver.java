/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 7
 * Date started:	September 28, 2022
 * Date finished:	October 2, 2022
 * Description:		This program demonstrates a selection of sorting algorithms
 *					from the text but in reverse(descending order).
 */
package sorting;

import java.util.Arrays;

import sorters.BubbleSort;
import sorters.InsertionSort;
import sorters.MergeSort;
import sorters.QuickSort;
import sorters.SelectionSort;
import sorters.ShellSort;

// This is the main class that drives the program
public class Driver {
	
	/*
	 * Description:	This is the main driving method for the package
	 * Precondition: None
	 * Postcondition: The results of each sorting algorithm will be output to the console
	 */
	public static void main(String[] args) {
		// Array to be sorted
		int[] original = {77, 86, 40, 87, 87, 4, 7, 84, 51, 76, 20, 50, 97};
		
		// New Sorting objects to process the sorts with
		SelectionSort sls = new SelectionSort();	
		InsertionSort is = new InsertionSort();
		BubbleSort bs = new BubbleSort();
		MergeSort ms = new MergeSort();
		QuickSort qs = new QuickSort();
		ShellSort ss = new ShellSort();

		// Selection Sort
		System.out.println("Selection Sort");
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(sls.sort(original)));
		System.out.println();	
		
		// Insertion Sort
		System.out.println("Insertion Sort");
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(is.sort(original)));
		System.out.println();		
		
		// Bubble Sort
		System.out.println("Bubble Sort");
		System.out.println(Arrays.toString(original));		
		System.out.println(Arrays.toString(bs.sort(original)));
		System.out.println();
		
		// Merge sort
		System.out.println("Mergesort");
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(ms.sort(original)));
		System.out.println();
		
		// Quick sort
		System.out.println("Quicksort");
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(qs.sort(original)));
		System.out.println();
		
		// Shell sort
		System.out.println("Shell Sort");
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(ss.sort(original)));
	}

}
